package 백준_2606;

import java.util.*;
import java.io.*;

public class Main {
    static int com, pair;
    static boolean [] visited;
    static ArrayList<ArrayList<Integer>> adjList;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        com = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();

        for (int i = 0; i <= com; i++)
            adjList.add(new ArrayList<>());

        for (int i = 1; i <= pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            adjList.get(com1).add(com2);
            adjList.get(com2).add(com1);
        }

        visited = new boolean [com + 1];

        DFS(1);

        System.out.println(count);
    }

    static void DFS(int v) {
        visited[v] = true;

        for (int i = 0; i < adjList.get(v).size(); i++) {
            if (!visited[adjList.get(v).get(i)]) {
                DFS(adjList.get(v).get(i));
                count++;
            }
        }
    }
}
