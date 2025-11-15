
import java.io.*;
import java.util.*;

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
        int from;
        int to;
        int weight;
       
        Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int[] parents;   
    static int[] ranks;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Edge(from, to, weight));
        }

        Collections.sort(graph);

        parents = new int[V+1];
        ranks = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        int answer = 0;
        int cnt = 0;
        for (Edge edge : graph) {
            if (union(edge.from, edge.to)) {
                answer += edge.weight;
                if (++cnt == V-1) break;
            }
        }

        System.out.println(answer);
    }   

    public static int find (int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union (int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;

        if (ranks[aRoot] > ranks[bRoot]) {
            parents[bRoot] = aRoot;
        } else if (ranks[aRoot] < ranks[bRoot]) {
            parents[aRoot] = bRoot;
        } else {
            parents[bRoot] = aRoot;
            ranks[aRoot]++;
        }
        return true;
    }
}
