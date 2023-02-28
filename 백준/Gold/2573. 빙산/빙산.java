import java.util.*;
import java.io.*;
public class Main {
    static int N, M, map[][], di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1};
    static Queue<int[]> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) queue.offer(new int[] {i, j});
            }
        }
        int time = 0;
        while (true) {
            time++;
            melt();
            int cnt = 0;
            boolean[][] visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        cnt++;
                        bfs(i, j, visited);
                    }
                }
            }
            if (cnt >= 2) break;
            else if (cnt == 0) {
                time = 0; break;
            }
            else init();
        }
        System.out.println(time);
        br.close();
    }
    public static void melt () {
        boolean[][] visited = new boolean[N][M];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            visited[i][j] = true;
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || visited[ni][nj]) continue;
                if (map[ni][nj] == 0) cnt++;
            }
            if (map[i][j] - cnt < 0) map[i][j] = 0;
            else map[i][j]-=cnt;
        }
    }

    public static void bfs (int i, int j, boolean[][] visited) {
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || visited[ni][nj] || map[ni][nj] == 0) continue;
                queue.offer(new int[] {ni, nj});
                visited[ni][nj] = true;
            }
        }
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) queue.offer(new int[] {i, j});
            }
        }
    }

    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
