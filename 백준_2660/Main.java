package 백준_2660;

import java.util.*;
import java.io.*;

public class Main {
    static int M;   // 회원 수
    static List<List<Integer>> friend;
    static int [] score, cap;
    static int minScore = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        M = Integer.parseInt(br.readLine());
        score = new int[M + 1];
        cap = new int[M + 1];
        friend = new ArrayList<>();

        for (int i = 0; i <= M; i++) {
            friend.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int F1 = Integer.parseInt(st.nextToken());
            int F2 = Integer.parseInt(st.nextToken());

            if (F1 == -1 && F2 == -1)
                break;

            friend.get(F1).add(F2);
            friend.get(F2).add(F1);
        }

        for (int i = 1; i <= M; i++)
            BFS(i);

        for (int i = 1; i <= M; i++) {
            minScore = Math.min(minScore, score[i]);
        }

        for (int i = 1; i <= M; i++) {
            if (score[i] == minScore) {
                count++;
            }
        }
        sb.append(minScore).append(" ").append(count).append("\n");
        for (int i = 1; i <= M; i++) {
            if (minScore == score[i])
                sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

    static void BFS(int v) {
        Queue<Node> queue = new LinkedList<>();
        boolean [] visited = new boolean [M + 1];    // 미안해..
        visited[v] = true;
        queue.offer(new Node(v, 0));
        int maxScore = 0;

        while(!queue.isEmpty()) {
            Node vertex = queue.poll();
            maxScore = Math.max(maxScore, vertex.score);

            for (int i = 0; i < friend.get(vertex.v).size(); i++) {
                int nextNode = friend.get(vertex.v).get(i);
                if (visited[nextNode])
                    continue;

                visited[nextNode] = true;
                queue.offer(new Node(nextNode, vertex.score + 1));
            }
        }
        score[v] = maxScore;
    }
}

class Node {
    int v, score;  // 시작 정점으로부터의 거리

    public Node(int v, int score) {
        this.v = v;
        this.score = score;
    }
}


