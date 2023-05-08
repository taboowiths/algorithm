import java.util.*;
import java.io.*;
public class Main {
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] input = new int[N+1];
            for (int i = 1; i <= N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visited = new boolean[N+1];
            boolean[] finished = new boolean[N+1];
            cnt = 0;

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) dfs(i, input, visited, finished);
            }
            System.out.println(N-cnt);
        }
    }

    public static void dfs (int cur, int[] input, boolean[] visited, boolean[] finished) {
        visited[cur] = true;
        int next = input[cur];
        if (!visited[input[cur]]) {
            dfs(input[cur], input, visited, finished);
        } else if (!finished[input[cur]]) {
            cnt++;
            while (cur != next) {
                cnt++;
                next = input[next];
            }
        }
        finished[cur] = true;
    }
}