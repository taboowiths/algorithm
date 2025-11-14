import java.util.*;
import java.io.*;

class Main {
    static int N, E;
    static List<List<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        graph = new ArrayList<>(Collections.nCopies(N+1, null));
        for (int i = 1; i <= N; i++) {
            graph.set(i, new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int result = dfs(1);
        System.out.println(result);
        br.close();
    }

    public static int dfs (int cur) {
        visited[cur] = true;
        int cnt = 0;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                cnt += 1 + dfs(next);
            }
        }
        return cnt;
    }
}