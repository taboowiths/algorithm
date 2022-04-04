package SWEA;
import java.util.*;
import java.io.*;

public class Solution_d4_1868_파핑파핑지뢰찾기_대전_5반_강정현 {
    static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 8방탐색

    static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static char[][] map, copy;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_d4_1868.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            copy = new char[N][N];
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j);
                }
            }

            countLandmine();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copy[i][j] == '0' && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copy[i][j] != '*' && copy[i][j] > 0 && !visited[i][j]) {
                        cnt++;
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
        br.close();
    }

    public static void bfs (int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int d = 0; d < 8; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || visited[ni][nj]) continue;
                if (copy[ni][nj] == '0') queue.offer(new int[] {ni, nj});
                visited[ni][nj] = true;
            }
        }
    }

    public static void countLandmine () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]=='.') { // 지뢰 아닌 곳.
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if (check(ni, nj) && map[ni][nj] == '*') {
                            cnt++;
                            copy[ni][nj] = '*';
                        }
                    }
                    copy[i][j] = (char) (cnt + '0');
                }
            }
        }
    }

    public static boolean check (int i, int j) {
        return (0 <= i) && (i < N) && (0 <= j) && (j < N);
    }
}
