import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int max = 100;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[max+1];
            dp[1] = dp[2] = dp[3] = 1;

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i-3] + dp[i-2];
            }
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
