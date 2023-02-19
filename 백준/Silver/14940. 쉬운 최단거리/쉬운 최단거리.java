import java.util.*;
import java.io.*;
public class Main {
    static int N, M, map[][], copyMap[][], di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x = i; y = j;
                }
            }
        }
        bfs(x, y);
        copyMap[x][y] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && copyMap[i][j] == 0) copyMap[i][j] = -1;
                sb.append(copyMap[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    public static void bfs (int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || map[ni][nj] == 0 || copyMap[ni][nj] != 0) continue;
                queue.offer(new int[]{ni, nj});
                copyMap[ni][nj] = copyMap[i][j] + 1;
            }
        }
    }
    public static boolean check(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
