package 백준_11724;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, u, v;
    static int[][] adjMat;
    static int count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 정점의 개수
        M = Integer.parseInt(st.nextToken());  // 간선의 개수
        adjMat = new int[N + 1][N + 1];  // 정점 번호가 1부터 시작해서 N까지
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        }

        BFS();
        System.out.println(count);
    }

    static void BFS() {
        for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    BFS(i);
                    count++;
                }
            }
        }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int head = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (visited[i])
                    continue;
                if (adjMat[head][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}




