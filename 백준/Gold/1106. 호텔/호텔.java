import java.util.*;
import java.io.*;
public class Main {
    static int INF = 999999;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken()); // 적어도 C명 늘려야 한다.
        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C+101];
        for (int i = 1; i <= C+100; i++) dp[i] = INF;
        int[] cost = new int[N+1];
        int[] visit = new int[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cost[i] = Integer.parseInt(st.nextToken());
            visit[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        int min = Integer.MAX_VALUE;
        for (int n = 1; n <= N; n++) { // 도시
            for (int c = 1; c <= C+100; c++) {
                if (c >= visit[n] && dp[c-visit[n]] != INF) dp[c] = Math.min(dp[c], dp[c-visit[n]]+cost[n]);
                if (c >= C) min = Math.min(min, dp[c]);
            }
        }
        System.out.println(min);
    }
}
