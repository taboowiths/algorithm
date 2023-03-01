import java.util.*;
import java.io.*;
public class Main {
    static int M, N, map[][], di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    map[j][i] = 1;
                }
            }
        }

//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        boolean[][] visited = new boolean[M][N];
        int cnt = 0;
        ArrayList<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != 1) {
                    visited[i][j] = true;
                    sizes.add(bfs(i, j, visited));
                    cnt++;
                }
            }
        }
        Collections.sort(sizes);
        System.out.println(cnt);
        for (int i = 0; i < sizes.size(); i++) System.out.print(sizes.get(i) + " ");
        br.close();
    }


    public static int bfs (int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            cnt++;
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < M && 0 <= nj && nj < N && !visited[ni][nj] && map[ni][nj] == 0) {
                    queue.offer(new int[] {ni, nj});
                    visited[ni][nj] = true;
                }
            }
        }
        return cnt;
    }
}
