import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] submit = new char[N+1]; // 승연의 답안
        char[] answer = new char[M+1]; // 정답
        String s1 = br.readLine(); String s2 = br.readLine();
        for (int i = 1; i <= N; i++) submit[i] = s1.charAt(i-1);
        for (int i = 1; i <= M; i++) answer[i] = s2.charAt(i-1);

        int[][] dp = new int[N+1][M+1];
        for (int i = 0; i <= N; i++) dp[i][0] = i;
        for (int j = 0; j <= M; j++) dp[0][j] = j;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (submit[i] == answer[j] ||
                        submit[i] == 'v' && answer[j] == 'w' ||
                        submit[i] == 'i' && (answer[j] == 'j' || answer[j] == 'l')
                ) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
