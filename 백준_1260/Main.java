package 백준_1260;

import java.io.*;
import java.util.*;

public class Main {
    static int V, E, route;
    static boolean [] visited;

    static int[][] adjMat;
    static Stack<Integer> stack;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        route = Integer.parseInt(st.nextToken());

        adjMat = new int[V + 1][V + 1];
        visited = new boolean[V + 1];
        stack = new Stack<>();

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int ver = Integer.parseInt(st.nextToken());
            int hor = Integer.parseInt(st.nextToken());
            adjMat[ver][hor] = 1;
            adjMat[hor][ver] = 1;
        }

        DFS(route);
        sb.append("\n");

        BFS(route);

        System.out.println(sb);
    }

    public static void DFS(int v) {
        stack.push(v);
        visited[v] = true;

        sb.append(v).append(" ");

        for (int i = 1; i <= V; i++) {
            if (adjMat[stack.peek()][i] == 1 && !visited[i])
                DFS(i);
        }
        stack.pop(); // 탐색 완료된 정점에 대해 pop
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited2 = new boolean[V + 1];

        queue.offer(v);
        visited2[v] = true;
        sb.append(v).append(" ");

        while (!queue.isEmpty()) {
            int head = queue.poll();
            for (int i = 1; i <= V; i++) {
                if (visited2[i])
                    continue;
                if (adjMat[head][i] == 1) {
                    queue.offer(i);
                    visited2[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}


