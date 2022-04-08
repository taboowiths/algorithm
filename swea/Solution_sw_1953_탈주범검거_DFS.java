package study;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_sw_1953_탈주범검거_DFS {

    static final int INF = 9999999;
    static int N, M, result, time, map[][], visited[][];
    static int[][] dir = {
            {0, 0, 0, 0},
            {1, 1, 1, 1}, // 1. 상하좌우
            {1, 1, 0, 0}, // 2. 상하
            {0, 0, 1, 1}, // 3. 좌우
            {1, 0, 0, 1}, // 4. 상우
            {0, 1, 0, 1}, // 5. 하우
            {0, 1, 1, 0},  // 6. 하좌
            {1, 0, 1, 0} // 7. 상좌
    };
    static int[] di = {-1, 1, 0, 0}; // 상하 좌우
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_sw_1953.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()); // 맨홀의 위치 x, y
            int y = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
            result = 0;
            map = new int[N][M];
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    visited[i][j] = INF;
                }
            }
            dfs(x, y, 1);
            System.out.println("#" + tc + " " + result);
        }
    }

    public static void dfs(int i, int j, int cnt) {
        if (cnt > time) return;
        if (visited[i][j] == INF) result++; // 미방문
        visited[i][j] = cnt;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (!check(ni, nj) || map[ni][nj] == 0) continue;
            int cur = map[i][j]; int next = map[ni][nj];
            int opp = (d+1)%2 == 1 ? d+1:d-1;
            if (dir[cur][d] == 1 && dir[next][opp] == 1) {
                if (visited[ni][nj] > cnt+1) { // 기존에 방문했던 시간보다 현재 방문한 시간이 빠른 경우만 방문.
                    dfs(ni, nj, cnt+1);
                }
            }
        }
    }
    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}