
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N+1];
        int[] profits = new int[N+1];
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        int itemWeight = 0; int itemProfit = 0;

        for (int i = 1; i <= N; i++) {
            itemWeight = weights[i];
            itemProfit = profits[i];

            for (int w = 1; w <= K; w++) {
                if (itemWeight <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-itemWeight] + itemProfit);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
