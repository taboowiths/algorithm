import java.io.*;
import java.util.*;

public class Main {
//    static int MAX = 200;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
        }

        for (int j = 1; j <= K; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000;
            }
        }

        System.out.println(dp[N][K]);
    }
}
