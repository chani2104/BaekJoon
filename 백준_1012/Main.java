package 백준_1012;

import java.util.*;
import java.io.*;

public class Main {
    static int T, M, N, K;
    static int[][] adjMat, map;
    static boolean[][] visited;
    static int count;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());  // 테스트 케이스 수

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt((st.nextToken()));  // 가로 (X)
            N = Integer.parseInt((st.nextToken()));  // 세로 (Y)
            K = Integer.parseInt((st.nextToken()));  // 총 배추의 개수

            adjMat = new int[N][M];
            visited = new boolean[N][M];
            map = new int[N][M];
            count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adjMat[Y][X] = 1;
            }

            BFS();
            System.out.println(count);
        }
    }

    public static void BFS() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j])
                    continue;
                if (adjMat[i][j] == 1) {
                    BFS(i, j);
                    count++;
                }
            }
        }
    }

    public static void BFS(int y, int x) {
        Queue<Node> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.offer(new Node(y, x));

        while (!queue.isEmpty()) {
            Node a = queue.poll();

            for (int i = 0; i < 4; i++) {       // 인접 행렬 상하좌우 조사하기
                int dy = dY[i] + a.y;
                int dx = dX[i] + a.x;

                if (dy < 0 || dx < 0 || dy >= N || dx >= M)    // 행렬 범위 벗어날 경우
                    continue;
                if (visited[dy][dx])  // 상하좌우로 이동한 곳이 이미 방문했던 곳일 경우
                    continue;
                if (adjMat[dy][dx] == 0)   // 상하좌우로 이동한 곳이 0일 경우
                    continue;

                visited[dy][dx] = true;    // 상하좌우로 조사한 곳을 방문
                queue.offer(new Node(dy, dx));    // 조사한 곳의 x, y 좌표를 묶어서 큐에 저장

            }
        }
    }
}

class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}




