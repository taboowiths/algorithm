import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception  {
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

        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
        distance[start] = 0;
        pq.offer(new int[] {start, distance[start]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]]) continue;

            visited[cur[0]] = true;

            for (int[] j : graph[cur[0]]) {
                if (!visited[j[0]] && distance[j[0]] > distance[cur[0]] + j[1]) {
                    distance[j[0]] = distance[cur[0]] + j[1];
                    pq.offer(new int[] {j[0], distance[j[0]]});
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
