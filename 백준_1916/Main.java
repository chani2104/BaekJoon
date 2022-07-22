package 백준_1916;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M; // N = 도시의 개수   M = 버스의 개수
    static long [] dist; // 최단 거리 배열
    static long [][] weight; // 가중치 인접 행렬
    static boolean [] visited; // 방문 여부 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new long[N + 1];
        weight = new long[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    weight[i][j] = 0;
                    continue;
                }
                weight[i][j] = Integer.MAX_VALUE - 1;     // 가중치값 2차원 배열 초기화
            }
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (weight[s][e] > c)
                weight[s][e] = c;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(start);

        System.out.println(dist[end]);
    }

    static void Dijkstra(int v) {
        visited[v] = true;  // 시작 정점 방문 처리

        for (int i = 1; i <= N; i++)
            dist[i] = weight[v][i];  // 시작 정점에서 도착 정점까지의 거리를 저장

        for (int i = 1; i < N; i++) {
            int curIdx = choose();
            visited[curIdx] = true;

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && dist[curIdx] + weight[curIdx][j] < dist[j]) {
                    dist[j] = dist[curIdx] + weight[curIdx][j];
                }
            }
        }
     }

     static int choose(){
        long min = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i = 1; i <= N; i++) {
             if (visited[i])
                 continue;
             if (dist[i] < min) {
                 min = dist[i];
                 minIdx = i;
             }
        }
        return minIdx;
     }
}
