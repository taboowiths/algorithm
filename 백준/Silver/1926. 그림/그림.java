import java.util.*;
import java.io.*;
public class Main {
    static int N, M, map[][], di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    max = Math.max(max, bfs(i, j, visited));
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
        br.close();
    }

    public static int bfs (int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            cnt++;
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || visited[ni][nj] || map[ni][nj] != 1) continue;
                queue.offer(new int[] {ni, nj});
                visited[ni][nj] = true;
            }
        }
        return cnt;
    }

    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
