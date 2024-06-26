import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for (int k = 0; k < N; k++) {
            dp[k] = 1;
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) dp[k] = Math.max(dp[k], dp[i] + 1);
            }
        }
        
        int result = -1;
        for (int i = 0; i < N; i++) {
            result = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}
