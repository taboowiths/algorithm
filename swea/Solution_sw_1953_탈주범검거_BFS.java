/*
결과 : 탈주범이 있을 수 있는 위치의 개수

1. 지하 터널은 총 7 종류의 터널 구조물로 구성됨.
2. 탈주범은 시간당 1의 거리를 움직일 수 있다.
3. 탈주범은 탈출한 지 한 시간 뒤, 맨홀 뚜껑을 통해 지하터널의 어느 한 지점으로 들어감.
*/

package study;
import java.io.*;
import java.util.*;

public class Solution_sw_1953_탈주범검거 {

    static int N, M, time, map[][];
    static boolean[][] visited;
    // 터널 구조물에 따라 갈 수 있는 방향이 달라짐.
    static int[][] dir = {
            {0, 0, 0, 0},
            {1, 1, 1, 1}, // 1. 상하좌우
            {1, 1, 0, 0}, // 2. 상하
            {0, 0, 1, 1}, // 3. 좌우
            {1, 0, 0, 1}, // 4. 상우
            {0, 1, 0, 1}, // 5. 하우
            {0, 1, 1, 0}, // 6. 하좌
            {1, 0, 1, 0} // 7. 상좌
    };
    static int[] di = {-1, 1, 0, 0}; // 상하 좌우
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_sw_1953.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()); // 맨홀의 위치 x, y
            int y = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            // cnt : 터널에 들어간 후 지난 시간.
            // result : 탈주범이 갈 수 있는 영역의 수.
            System.out.println("#" + tc + " " + bfs(x, y, 1, 1));
        }
    }

    public static int bfs(int i, int j, int cnt, int result) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new int[]{i, j, cnt});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            cnt = cur[2];
            if (cnt == time) break;
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || visited[ni][nj] || map[ni][nj] == 0) continue;
                int next = map[ni][nj];
                int opp = (d+1) % 2 == 1 ? d+1 : d-1; // 현재 방향의 반대 방향을 의미.

                if (dir[map[i][j]][d] == 1 && dir[next][opp] == 1) { // 현위치의 순방향 + 다음 위치의 역방향이 이동 가능.
                    result++;
                    visited[ni][nj] = true;
                    queue.offer(new int[]{ni, nj, cnt+1});
                }
            }
        }
        return result;
    }

    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}