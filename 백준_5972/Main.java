package 백준_5972;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int [] dist;
    static boolean [] visited;
    static ArrayList<ArrayList<Node>> weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        weight = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            weight.add(new ArrayList<>());
            dist[i] = 50000001;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            weight.get(s).add(new Node(e, cost));
            weight.get(e).add(new Node(s, cost));
        }

        Dijkstra(1);;
        System.out.println(dist[N]);

    }

    static void Dijkstra(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[v] = 0;
        pq.add(new Node(v, 0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int min = curNode.weight;
            int minIdx = curNode.index;
            if (visited[minIdx] && dist[minIdx] < min)    // dist[minIdx] < min -> 이미 최소면 pass
                continue;
            visited[minIdx] = true;


            for (int i = 0; i < weight.get(minIdx).size(); i++) {
                if (dist[minIdx] + weight.get(minIdx).get(i).weight < dist[weight.get(minIdx).get(i).index]) {
                    dist[weight.get(minIdx).get(i).index] = dist[minIdx] + weight.get(minIdx).get(i).weight;
                    pq.add(new Node(weight.get(minIdx).get(i).index, weight.get(minIdx).get(i).weight));
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
