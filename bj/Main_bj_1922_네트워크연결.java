package bj;

import java.io.*;
import java.util.*;

public class Main_bj_1922_네트워크연결 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        public Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }
    static int N, parents[];
    static Edge[] edgelist;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_1922.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        edgelist = new Edge[E];
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgelist[i] = new Edge(from, to, weight);
        }
        Arrays.sort(edgelist);
        makeSet();

        int result = 0, cnt = 0;
        for (Edge edge : edgelist) {
            if (union(edge.from, edge.to)){
                result += edge.weight;
                if (++cnt == N) break;
            }
        }
        System.out.println(result);
        br.close();
    }

    static void makeSet() {
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet (int a) {
        if (a==parents[a]) return a;
        return parents[a]=findSet(parents[a]);
    }

    static boolean union (int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
