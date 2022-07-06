package 백준_11725;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int [] parent;
    static boolean [] visited;
    static ArrayList<ArrayList<Integer>> adjList;
    static int i = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();  // 배열 리스트 안에 배열 리스트로 이차원 배열 생성

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());  // 큰 개념의 배열 리스트의 각 인덱스 마다 배열 리스트 추가
        }

        for (int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        DFS(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int v) {
        visited[v] = true;

        for (int i = 0; i < adjList.get(v).size(); i++){
            if (!visited[adjList.get(v).get(i)]) {
                parent[adjList.get(v).get(i)] = v;
                DFS(adjList.get(v).get(i));
            }
        }
    }
}