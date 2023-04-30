import java.io.*;
import java.util.*;
public class Main {
    static int N, di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1};
    static boolean[][] lightOn;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[][] map = new ArrayList[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int to_x = Integer.parseInt(st.nextToken());
            int to_y = Integer.parseInt(st.nextToken());
            map[start_x][start_y].add(new int[] {to_x, to_y});
        }

        lightOn = new boolean[N+1][N+1];

        int ans = 1;
        int check;
        do {
            check = ans;
            ans = bfs(1, 1, map, check);
        } while (ans != check);

        System.out.println(ans);
    }

    public static int bfs (int i, int j, List<int[]>[][] map, int check) {
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        lightOn[i][j] = true;
        int ans = check;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int[] light : map[i][j]) {
                if (!lightOn[light[0]][light[1]]) {
                    ans++;
                    lightOn[light[0]][light[1]] = true; // 불 켜줌
                }
            }
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || visited[ni][nj] || !lightOn[ni][nj]) continue;
                queue.offer(new int[] {ni, nj});
                visited[ni][nj] = true;
            }
        }
        return ans;
    }

    public static boolean check (int i, int j) {
        return 0 < i && i <= N && 0 < j && j <= N;
    }
}
