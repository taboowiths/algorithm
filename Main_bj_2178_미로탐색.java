package bj;
import java.io.*;
import java.util.*;

public class Main_bj_2178_미로탐색 {

    static int N, M;
    static int[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_2178.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    static int bfs (int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || map[ni][nj] == 0 || visited[ni][nj]) continue;
                visited[ni][nj] = true;
                map[ni][nj] = map[i][j] + 1;
                queue.offer(new int[]{ni, nj});
            }
        }
        return map[N-1][M-1];
    }

    static boolean check(int i, int j){
        if (0 <= i && i < N && 0 <= j && j < M) return true;
        return false;
    }
}
