
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MAX = 501;
        int[] wires = new int[MAX];

        StringTokenizer st;
        int start = 501;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            wires[A] = B;
            start = Math.min(start, A);
        }
        int[] dp = new int[MAX];
        for (int k = start; k < MAX; k++) {
            dp[k] = 1;
            for (int i = start; i < k; i++) {
                if (wires[i] != 0 && wires[i] < wires[k]) dp[k] = Math.max(dp[k], dp[i] + 1);
            }
        }
        Arrays.sort(dp);
        System.out.println(N-dp[MAX-1]);
    }
}
