package 백준_2583;

import java.util.*;
import java.io.*;

public class Main {
    static int M, N, K;
    static boolean [][] visited;
    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int rectCount = 0;
    static ArrayList<Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        count = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int j = leftY; j < rightY; j++) {
                for (int k = leftX; k < rightX; k++) {
                    visited[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    rectCount = 0;
                    DFS(i, j);
                    count.add(rectCount);
                }
            }
        }
        Collections.sort(count);

        sb.append(count.size()).append("\n");
        for (Integer integer : count) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }

    static void DFS (int row, int col) {
        visited[row][col] = true;
        rectCount++;

        for (int i = 0; i < 4; i++) {
            int dr = row + dR[i];
            int dc = col + dC[i];

            if (dr < 0 || dc < 0 || dr >= M || dc >= N)
                continue;
            if (visited[dr][dc])
                continue;

            DFS(dr, dc);
        }
    }
}
