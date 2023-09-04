import java.util.*;
import java.io.*;
public class Main {
    static int M = 29, S = 14, N;
    static int[] di={0, 0, 1, -1}, dj={1, -1, 0, 0}; // 동서남북
    static double answer;
    static double[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        input = new double[4];
        answer = 0.0;
        for (int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }
        boolean[][] visited = new boolean[M][M];
        dfs(S, S, 0, 1.0, visited);
        System.out.println(answer);
    }

    public static void dfs (int i, int j, int cnt, double result, boolean[][] visited) {
        if (cnt == N) {
            answer += result;
            return;
        }
        visited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (visited[ni][nj]) continue;
            visited[ni][nj] = true;
            dfs(ni, nj, cnt+1, result * input[d], visited);
            visited[ni][nj] = false;
        }
    }
}
