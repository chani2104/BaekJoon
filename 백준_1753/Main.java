package 백준_1753;

import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static int [] dist;
    static boolean [] visited;
    static List<ArrayList<Node>> weight;     // 넓은 범위의 함수를 사용 가능

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        visited = new boolean[V + 1];
        weight = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            weight.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            weight.get(start).add(new Node(end, cost));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();     // 마찬가지로 더 많은 범주의 함수 사용을 위해 Queue 형 선언
        dist[K] = 0;
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            for (int i = 0; i < weight.get(curNode.index).size(); i++) {
                Node nextNode = weight.get(curNode.index).get(i);
                if (dist[curNode.index] + nextNode.weight < dist[nextNode.index]) {
                    dist[nextNode.index] = dist[curNode.index] + nextNode.weight;
                    pq.add(new Node(nextNode.index, dist[nextNode.index]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int index, weight;

    public Node(int index, int weight){
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n){
        return weight - n.weight;
    }
}
