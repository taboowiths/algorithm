import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S1 = ("0" + br.readLine()).toCharArray();
        char[] S2 = ("0" + br.readLine()).toCharArray();

        int[][] dp = new int[S1.length][S2.length];
        for (int i = 1; i < S1.length; i++) {
            for (int j = 1; j < S2.length; j++) {
                if (S1[i] == S2[j]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

            }
        }
        System.out.println(dp[S1.length-1][S2.length-1]);
    }
}
