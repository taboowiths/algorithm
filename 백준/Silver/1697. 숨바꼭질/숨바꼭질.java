import java.io.*;
import java.util.*;
public class Main {
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Boolean[] visited = new Boolean[100001];
        Arrays.fill(visited, false);
        bfs(visited, N, K);
        System.out.println(ans);
        br.close();
    }

    public static void bfs (Boolean[] visited, int N, int K) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = true;

        int size = 0;
        int step = -1;
        while (!queue.isEmpty()) {
            size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == K) {
                    ans = step;
                    return;
                }
                if (cur+1 >= 0 && cur+1 <= 100000 && !visited[cur+1]) {
                    queue.offer(cur+1);
                    visited[cur+1] = true;
                }
                if (cur-1 >= 0 && cur-1 <= 100000 && !visited[cur-1]) {
                    queue.offer(cur-1);
                    visited[cur-1] = true;
                }
                if (0 <= cur*2 && cur*2 <= 100000 && !visited[cur*2]) {
                    queue.offer(cur*2);
                    visited[cur*2] = true;
                }
            }
        }
    }
}
