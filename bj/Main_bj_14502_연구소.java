package bj;
import java.util.*;
import java.io.*;
public class Main_bj_14502_연구소 {
    static int N, M, max, map[][], walls[][];
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static List<int[]> virus;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_14502.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        map = new int[N][M];
        walls = new int[3][2];
        virus = new ArrayList<>();
        for (int wall[] : walls) Arrays.fill(wall, 0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[] {i, j});
            }
        }
        pickLocation(0, 0);
        System.out.println(max);
    }

    static void pickLocation (int cnt, int start) {
        if (cnt == 3) {
            for (int[] wall : walls) {
                if (map[wall[0]][wall[1]] != 0) return;
            }
            max = Math.max(max, spread());
        } else {
            for (int i = start; i < N * M; i++) {
                int x = i / M;
                int y = i % M;

                walls[cnt] = new int[]{x, y};
                pickLocation(cnt + 1, i + 1);
            }
        }
    }
    
    static int spread () {
        int[][] copy = copyMap();
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] wall : walls) {
            copy[wall[0]][wall[1]] = 1; // 벽 세우기
        }

        for (int[] v:virus) {
            queue.offer(v);
        }

        // 바이러스 확산
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if (!check(ni, nj) || visited[ni][nj] || copy[ni][nj] != 0) continue;
                copy[ni][nj] = 2;
                visited[ni][nj] = true;
                queue.offer(new int[] {ni, nj});
            }
        }
        return countSafe(copy);
    }

    static int countSafe (int[][] copy) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
    static int[][] copyMap () {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    static boolean check(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
