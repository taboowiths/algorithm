import java.util.*;
import java.io.*;
public class Main {
    static List<Integer>[] g;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        g = new List[N+1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[from].add(to);
            g[to].add(from);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    public static void bfs (int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            i = queue.poll();
            for (int j : g[i]) {
                if (!visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
