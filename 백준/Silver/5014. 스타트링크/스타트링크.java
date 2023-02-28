import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] info = new int[5];
        // 0: 층 수, 1: 현재 층, 2: 목적지, 3: 위, 4: 아래
        for (int i = 0; i < 5; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
        Boolean[] visited = new Boolean[info[0]+1];
        Arrays.fill(visited, false);
        int ans = bfs(info, visited);
        if (ans == -1) System.out.println("use the stairs");
        else System.out.println(ans);
        br.close();
    }
    public static int bfs (int[] info, Boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(info[1]);
        visited[info[1]] = true;

        int size = 0;
        int cnt = -1;
        while (!queue.isEmpty()) {
            size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == info[2]) return cnt;
                if (cur + info[3] <= info[0] && !visited[cur+info[3]]) {
                    queue.offer(cur+info[3]);
                    visited[cur+info[3]] = true;
                }
                if (cur - info[4] >= 1 && !visited[cur-info[4]]) {
                    queue.offer(cur-info[4]);
                    visited[cur-info[4]] = true;
                }
            }
        }
        return -1;
    }
}
