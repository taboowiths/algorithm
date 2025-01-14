import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<int[]>[] graph = new List[V+1];
        for (int i = 0; i <= V; i++) graph[i] = new ArrayList<>();

        int[] distance = new int[V+1];
        for (int i = 1; i <= V; i++) distance[i] = Integer.MAX_VALUE;

        boolean[] visited = new boolean[V+1];

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new int[] {to, weight});
        }

        distance[start] = 0;
        for (int i = 1; i <= V; i++) {
            int min = Integer.MAX_VALUE; int cur = 0;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    cur = j;
                }
            }

            visited[cur] = true;

            for (int[] j : graph[cur]) {
                if (!visited[j[0]] && distance[j[0]] > distance[cur] + j[1]) {
                    distance[j[0]] = distance[cur] + j[1];
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(distance[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
