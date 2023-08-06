import java.io.*;
import java.util.*;
public class Main {
    static int N, M, min;
    static int[] di={-1, 1, 0, 0}, dj={0, 0, -1, 1};
    static int[][] map;
    static class Pos {
        int x, y, cnt;
        int used; // 0: 사용안함, 1: 사용함
        Pos (int x, int y, int cnt, int used) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.used = used;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j-1) - '0';
            }
        }
        boolean[][][] visited = new boolean[N+1][M+1][2];
        bfs(1, 1, visited);
        int result = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(result);
    }

    static void bfs (int i, int j, boolean[][][] visited) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(i, j, 1, 0));
        visited[i][j][0] = true;
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            if (cur.x == N && cur.y == M) {
                min = Math.min(min, cur.cnt);
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int ni = cur.x + di[d];
                int nj = cur.y + dj[d];
                if (!check(ni, nj)) continue;
                if (map[ni][nj] == 1 && cur.used == 0) {
                    queue.offer(new Pos(ni, nj, cur.cnt+1, 1));
                    visited[ni][nj][1] = true;
                } else if (map[ni][nj] == 0 && !visited[ni][nj][cur.used]) {
                    queue.offer(new Pos(ni, nj, cur.cnt+1, cur.used));
                    visited[ni][nj][cur.used] = true;
                }
            }
        }
    }

    static boolean check (int i, int j) {
        return 0 < i && i <= N && 0 < j && j <= M;
    }
}
