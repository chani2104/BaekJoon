package 백준_2468;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int heightMax = 0;
    static int countMax = 0; // 음수도 가능할 때에는 Integer.MIN_VALUE로 비교 (int 형 정수의 최솟값)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] > heightMax)
                    heightMax = area[i][j];
            }
        }

        while (heightMax >= 0) {
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] <= heightMax)
                        visited[i][j] = true;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        DFS(i, j);
                        count++;
                    }
                }
            }

            countMax = Math.max(countMax, count);
            heightMax--;
        }
        System.out.println(countMax);
    }

    static void DFS(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int dr = dR[i] + row;
            int dc = dC[i] + col;

            if (dr < 0 || dc < 0 || dr >= N || dc >= N)
                continue;
            if (visited[dr][dc])
                continue;

            DFS(dr, dc);
        }
    }
}
