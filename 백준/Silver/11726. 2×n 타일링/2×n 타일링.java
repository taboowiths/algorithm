import java.util.*;
import java.io.*;

public class Main {
    static int max = 1000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[max+1];

        dp[1] = 1;
        dp[2] = 2;

        if (N >= 3) {
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i-2] + dp[i-1])%10007;
            }
        }
        System.out.println(dp[N] % 10007);
    }
}
