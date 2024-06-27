import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        for (int k = N-1; k >= 0; k--) {
            dp[k] = 1;
            for (int i = N-1; i >= k; i--) {
                if (arr[i] < arr[k]) dp[k] = Math.max(dp[k], dp[i] + 1);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}
