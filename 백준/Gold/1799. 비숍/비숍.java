import java.util.*;
import java.io.*;
public class Main {
    static int N, map[][], max[];
    static boolean visited[][], chess[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        max = new int[2];
        map = new int[N][N];
        visited = new boolean[N][N];
        chess = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                chess[i][j] = (i + j) % 2 == 0;
            }
        }
        setBishop(0, 0, true);
        setBishop(0, 0, false);

        System.out.println(max[0]+max[1]);
        br.close();
    }

    public static void setBishop (int cnt, int start, boolean black) {
        for (int i = start; i < N*N; i++) {
            int x = i / N;
            int y = i % N;

            if (map[x][y] == 0 || chess[x][y] != black || !isAvailable(x, y)) continue;

            visited[x][y] = true;
            setBishop(cnt+1, i+1, black);
            visited[x][y] = false;
        }
        max[black?0:1] = Math.max(max[black?0:1], cnt);
    }

    public static boolean isAvailable (int x, int y) {
        int[] di = {-1, -1};
        int[] dj = {-1, 1};

        for (int d = 0; d < 2; d++) {
            int nx = x;
            int ny = y;
            while (true) {
                if (0 > nx || nx >= N || 0 > ny || ny >= N) break;
                if (visited[nx][ny]) return false;

                nx += di[d];
                ny += dj[d];
            }
        }
        return true;
    }
}
