import java.util.*;
import java.io.*;
public class Main {
    static int di[] = {0, -1, -1, -1, 0, 1, 1, 1}, dj[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int N, M, map[][], clouds[][];
    static boolean isClouded[][];
    static Queue<int[]> queue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isClouded = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isClouded[N-1][0] = isClouded[N-1][1] = isClouded[N-2][0] = isClouded[N-2][1] = true;
        clouds = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            clouds[i] = new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())};
        }

        for (int i = 0; i < M; i++) {
            init();
            moveCloud(i);
            waterCopy();
            makeCloud();
        }

        int water = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                water += map[i][j];
            }
        }
        System.out.println(water);
        br.close();
    }

    public static void init () {
        queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isClouded[i][j]) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        isClouded = new boolean[N][N];
    }

    public static void moveCloud (int cnt) {
        int dir = clouds[cnt][0];
        int move = clouds[cnt][1] % N;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            for (int m = 0; m < move; m++) {
                int ni = i + di[dir];
                int nj = j + dj[dir];
                if (!check(ni, nj)) {
                    if (ni < 0) ni = N-1;
                    if (nj < 0) nj = N-1;
                    if (ni >= N) ni = 0;
                    if (nj >= N) nj = 0;
                }
                i = ni; j = nj;
            }
            isClouded[i][j] = true;
        }
//        System.out.println(Arrays.deepToString(isClouded));
        // 물 양 증가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isClouded[i][j]) {
                    map[i][j] += 1;
                    queue.offer(new int[] {i, j});
                }
            }
        }
    }

    public static void waterCopy () {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            int cnt = 0;
            for (int k = 1; k <= 7; k+=2) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (check(ni, nj) && map[ni][nj] > 0) cnt++;
            }
            map[i][j] += cnt;
        }
    }

    public static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2 && !isClouded[i][j]) {
                    map[i][j] -= 2;
                    isClouded[i][j] = true;
                }
                else if (isClouded[i][j]) isClouded[i][j] = false;
            }
        }
    }

    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}
