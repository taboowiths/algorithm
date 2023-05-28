import java.io.*;
import java.util.*;
public class Main { 
    static List<int[]>[] graph;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new int[] {to, cost});
        }
        
        int[] distance = new int[N+1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int result = 0;
            result += (dijkstra(i, X, distance) + dijkstra(X, i, distance));
            max = Math.max(max, result);
        }
        System.out.println(max);
    }

    public static int dijkstra (int start, int end, int[] distance) {
        for (int j = 1; j <= N; j++) distance[j] = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N+1];

        distance[start] = 0;
        for (int i = 1; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            int cur = start;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    cur = j;
                }
            }

            visited[cur] = true;
            if (cur == end) break;

            for (int[] j : graph[cur]) {
                if (!visited[j[0]] && distance[j[0]] > distance[cur] + j[1]) {
                    distance[j[0]] = distance[cur] + j[1];
                }
            }
        }
        return distance[end];
    }
}
