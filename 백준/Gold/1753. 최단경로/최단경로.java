
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 52462
 */
public class Main {
    static class Edge implements Comparable<Edge> {
        int to; 
        int weight;
        Edge (int to, int weight) {
            this.to = to;
            this.weight = weight; 
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    
    static List<List<Edge>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.weight > dist[cur.to]) continue;

            for (Edge next : graph.get(cur.to)) {
                
                // cur.to와 연결된 모든 next 를 살펴보면서 각각의 최소 거리를 업데이트 함.
                // dist[next] = Math.min((cur까지의 최단경로 + cur-next까지의 경로), 현재 dist[next])

                int newWeight = cur.weight + next.weight;
                if (newWeight < dist[next.to]) {
                    dist[next.to] = newWeight;
                    pq.add(new Edge(next.to, newWeight));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
