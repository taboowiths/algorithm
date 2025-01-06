import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[N][3];

            dp[0][0] = 0; // 미선택
            dp[0][1] = sticker[0][0]; // 윗줄 선택 초기값
            dp[0][2] = sticker[1][0]; // 아래줄 선택 초기값
            for (int i = 1; i < N; i++) {
                // 1. 아무것도 선택 안하는 경우 = Max(아무것도, 윗줄, 아랫줄)
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));

                // 2. 윗줄 선택하는 경우 = Max(아무것도, 아랫줄) + 점수
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + sticker[0][i];

                // 3. 아랫줄 선택하는 경우 = Max(아무것도, 윗줄) + 점수
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + sticker[1][i];
            }
            sb.append(Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]))).append("\n");
        }
        System.out.println(sb.toString());
    }
}
