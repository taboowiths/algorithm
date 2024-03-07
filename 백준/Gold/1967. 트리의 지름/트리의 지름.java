import java.util.*;
import java.io.*;
public class Main {
    static int N, maxValue, maxNode;
    static List<int[]>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            graph[P].add(new int[] {C, W});
            graph[C].add(new int[] {P, W});
        }
        visited = new boolean[N+1];
        maxValue = -1;
        dfs(1, 0);

        maxValue = -1;
        Arrays.fill(visited, false);
        dfs(maxNode, 0);
        System.out.println(maxValue);
    }

    public static void dfs (int cur, int val) {
        visited[cur] = true;
        if (maxValue < val) {
            maxValue = val;
            maxNode = cur;
        }
        for (int[] node : graph[cur]) {
            if (visited[node[0]]) continue;
            dfs(node[0], val + node[1]);
        }
    }
}
