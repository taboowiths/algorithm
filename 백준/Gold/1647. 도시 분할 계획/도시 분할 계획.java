import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static int[] parents;
    static int[][] edgeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new int[E][];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new int[] {from, to, weight};
        }

        Arrays.sort(edgeList, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        makeSet();

        int result = 0, cnt = 0, max = 0;
        for (int[] edge : edgeList) {
            if (union(edge[0], edge[1])) {
                result += edge[2];
                max = Math.max(max, edge[2]);
                if (++cnt == N-1) break;
            }
        }
        System.out.println(result-max);
    }

    public static void makeSet() {
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
