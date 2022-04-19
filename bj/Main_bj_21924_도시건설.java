package study.a0418;
import java.util.*;
import java.io.*;
public class Main_bj_21924_도시건설 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        public Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return this.weight-o.weight;
        }
    }
    static int N, M, parents[];
    static Edge[] edgelist;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_21924.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edgelist = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgelist[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgelist);
        makeSet();

        long result=0, cnt=0, all = 0;
        for (Edge edge:edgelist) all += edge.weight; // 도로를 모두 설치할 때의 비용.
        for (Edge edge:edgelist) {
            if (union(edge.from, edge.to)) {
                System.out.println(edge.weight);
                result += edge.weight; // 모든 건물을 연결하는 최소한의 도로만 만드는 비용.
                if (++cnt == N-1) break;
            }
        }
        //System.out.println(cnt + " " + N);
        if (cnt == N-1) System.out.println(all-result);
        else System.out.println(-1);
    }

    static void makeSet() {
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
