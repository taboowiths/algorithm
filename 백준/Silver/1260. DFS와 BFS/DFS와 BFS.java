import java.io.*;
import java.util.*;

public class Main {
    static int N, E, V;
    static List<Integer>[] edgelist;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        edgelist = new List[N+1];
        for (int i = 1; i <= N; i++) edgelist[i] = new ArrayList<>();

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgelist[from].add(to);
            edgelist[to].add(from);
        }

        for(int i=1; i <= N; i++){
            Collections.sort(edgelist[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);
        br.close();
    }

    static void dfs (int i) {
        visited[i] = true;
        sb.append(i).append(" ");
        for (int j : edgelist[i]) {
            if (!visited[j]) dfs(j);
        }
    }

    static void bfs (int i){
        Queue<Integer> queue = new ArrayDeque<>();
        visited[i] = true;
        queue.offer(i);
        while (!queue.isEmpty()) {
            i = queue.poll();
            sb.append(i).append(" ");
            for (int j : edgelist[i]) {
                if (!visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
