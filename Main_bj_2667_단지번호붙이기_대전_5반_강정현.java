package bj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_2667_단지번호붙이기_대전_5반_강정현 {

    static int N, num;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static ArrayList<Integer> houses;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_2667.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        houses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        Collections.sort(houses);

        System.out.println(cnt);
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(houses.get(i));
        }
        br.close();
    }

    public static void bfs (int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        num = 1; // 단지 내 집의 수
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || visited[ni][nj] || map[ni][nj] != 1) continue;
                num++;
                map[ni][nj] = 0;
                visited[ni][nj] = true;
                queue.offer(new int[] {ni, nj});
            }
        }
        houses.add(num);
    }

    public static boolean check (int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < N) return true;
        return false;
    }
}
