package bj;
import java.io.*;
import java.util.*;

public class Main_bj_2636_치즈_대전_5반_강정현 {
    static int N, M, cheese;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_2636.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int hour = 0, res = 0;
        cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }
        while (cheese != 0) {
            hour++;
            res = cheese;
            bfs(0, 0);
        }
        System.out.println(hour);
        System.out.println(res);
        br.close();
    }

    public static void bfs (int i, int j){
        Queue<int[]> queue = new ArrayDeque<>();
        visited = new boolean[N][M];
        visited[i][j] = true;
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()){
            int cur[] = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!checkBound(ni, nj) || visited[ni][nj]) continue;
                if (map[ni][nj] == 1) { // 치즈면
                    cheese--;
                    map[ni][nj] = 0;
                }
                else if (map[ni][nj] == 0) { // 공간이면
                    queue.offer(new int[] {ni, nj});
                }
                visited[ni][nj] = true;
            }
        }
    }
    public static boolean checkBound (int i, int j){
        if (0 <= i && i < N && 0 <= j && j < M) return true;
        return false;
    }
}