import java.util.*;
import java.io.*;
public class Main {
    static long DIV = 1000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[input.length()+1];
        for (int i = 1; i <= input.length(); i++) arr[i] = input.charAt(i-1)-'0';
        System.out.println(Solution2(arr));
    }

    public static long Solution2 (int[] arr) {
        if (arr[1] == 0) return 0;
        long[] dp = new long[arr.length];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i-1]==0 && arr[i]==0) return 0;
            if (arr[i-1] > 2 && arr[i]==0) return 0;

            if (arr[i] == 0) dp[i] = dp[i-2]%DIV;
            else if (10 < arr[i-1]*10+arr[i] && arr[i-1]*10+arr[i] <= 26) dp[i] = (dp[i-1] + dp[i-2])%DIV;
            else dp[i] = dp[i-1]%DIV;
        }
        return dp[arr.length-1];
    }
}
