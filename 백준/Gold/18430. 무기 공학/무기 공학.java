import java.io.*;
import java.util.*;
public class Main {
    static int N, M, map[][], max;
    static boolean[][] visited;
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
        visited = new boolean[N][M];
        dfs(0, 0);
        System.out.println(max);
    }

    public static void dfs (int idx, int sum) {
        if (idx == N*M) {
            max = Math.max(max, sum);
            return;
        }

        int x = idx/M;
        int y = idx%M;

        if (!visited[x][y]) {
            // ㄱ 거울
            if (x+1 < N && y+1 < M && !visited[x+1][y] && !visited[x][y+1]) {
                visited[x][y] = true;
                visited[x+1][y] = true;
                visited[x][y+1] = true;
                dfs(idx+1, sum + (map[x][y]*2) + map[x+1][y] + map[x][y+1]);
                visited[x][y] = false;
                visited[x+1][y] = false;
                visited[x][y+1] = false;
            }
            // ㄴ 거울
            if (0 <= x-1 && 0 <= y-1 && !visited[x-1][y] && !visited[x][y-1]) {
                visited[x][y] = true;
                visited[x-1][y] = true;
                visited[x][y-1] = true;
                dfs(idx+1, sum + (map[x][y]*2) + map[x-1][y] + map[x][y-1]);
                visited[x][y] = false;
                visited[x-1][y] = false;
                visited[x][y-1] = false;
            }
            // ㄴ
            if (0 <= x-1 && y+1 < M && !visited[x-1][y] && !visited[x][y+1]) {
                visited[x][y] = true;
                visited[x-1][y] = true;
                visited[x][y+1] = true;
                dfs(idx+1, sum + (map[x][y]*2) + map[x-1][y] + map[x][y+1]);
                visited[x][y] = false;
                visited[x-1][y] = false;
                visited[x][y+1] = false;
            }
            // ㄱ
            if (x+1 < N && 0 <= y-1 && !visited[x+1][y] && !visited[x][y-1]) {
                visited[x][y] = true;
                visited[x+1][y] = true;
                visited[x][y-1] = true;
                dfs(idx+1, sum + (map[x][y]*2) + map[x+1][y] + map[x][y-1]);
                visited[x][y] = false;
                visited[x+1][y] = false;
                visited[x][y-1] = false;
            }
        }
        dfs(idx+1, sum);
    }
}
