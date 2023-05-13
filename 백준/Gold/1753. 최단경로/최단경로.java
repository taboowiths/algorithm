
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int vertex, cost;
        Node link;
        public Node (int vertex, int cost, Node link) {
            this.vertex = vertex;
            this.cost = cost;
            this.link = link;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        Node[] g=new Node[V+1];
        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            g[from] = new Node(to, cost, g[from]);
        }
        distance[K] = 0;
        for (int i = 1; i <= V; i++) {
            int min = Integer.MAX_VALUE;
            int cur = 0;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    cur = j;
                }
            }

            visited[cur] = true;

            for (Node j = g[cur]; j!=null; j=j.link) {
                if (!visited[j.vertex] && distance[j.vertex] > distance[cur] + j.cost) {
                                          distance[j.vertex] = distance[cur] + j.cost;
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}
