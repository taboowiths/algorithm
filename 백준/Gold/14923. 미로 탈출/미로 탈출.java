import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Hx, Hy, Ex, Ey, min;
    static int[] di={-1, 1, 0, 0}, dj={0, 0, -1, 1};
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Hx = Integer.parseInt(st.nextToken())-1;
        Hy = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine(), " ");
        Ex = Integer.parseInt(st.nextToken())-1;
        Ey = Integer.parseInt(st.nextToken())-1;
        map = new int[N][M];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][][] visited = new boolean[N][M][2];
        bfs(Hx, Hy, 0, 0, visited);
        int result = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(result);
    }
    // 0 사용안함 1 사용함
    static void bfs (int i, int j, int used, int cnt, boolean[][][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j, used, cnt});
        visited[i][j][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            used = cur[2];
            cnt = cur[3];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj)) continue;
                if (ni == Ex && nj == Ey){
                    min = Math.min(min, cnt+1);
                    continue;
                }
                if (map[ni][nj] == 1 && used == 0) {
                    queue.offer(new int[]{ni, nj, 1, cnt+1});
                    visited[ni][nj][1] = true;
                }
                else if (map[ni][nj] == 0 && !visited[ni][nj][used]) {
                    queue.offer(new int[] {ni, nj, used, cnt+1});
                    visited[ni][nj][used] = true;
                }
            }
        }
    }

    static boolean check(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }


}
