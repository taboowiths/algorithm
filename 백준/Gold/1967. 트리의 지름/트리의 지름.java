import java.io.*;
import java.util.*;

public class Main {
    static int max, maxNode;
    static List<int[]>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
           st = new StringTokenizer(br.readLine(), " ");
           int from = Integer.parseInt(st.nextToken());
           int to = Integer.parseInt(st.nextToken());
           int weight = Integer.parseInt(st.nextToken());
           graph[from].add(new int[] {to, weight});
           graph[to].add(new int[] {from, weight});
        }

        max = Integer.MIN_VALUE;
        visited = new boolean[N+1];
        dfs(1, 0);

        max = Integer.MIN_VALUE;
        visited = new boolean[N+1];
        dfs(maxNode, 0);
        System.out.println(max);
    }
    // 루트 1에서 가장 긴 것 -> 가장 긴 것부터 가장 긴 것
    public static void dfs (int i, int sum) {
        visited[i] = true;
        if (sum > max) {
            max = sum;
            maxNode = i;
        }
        for (int[] j : graph[i]) {
            if (visited[j[0]]) continue;
            dfs(j[0], sum + j[1]);
        }
    }
}
