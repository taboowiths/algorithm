import java.io.*;

public class Main {
    static int MOD = 1000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] DP = new long[N+1][2][3];
        DP[1][0][0] = 1; DP[1][0][1] = 1; DP[1][1][0] = 1;

        for (int i = 1; i < N; i++) {
            DP[i+1][0][0] = (DP[i][0][0] + DP[i][0][1] + DP[i][0][2]) % MOD;
            DP[i+1][0][1] = DP[i][0][0];
            DP[i+1][0][2] = DP[i][0][1];

            DP[i+1][1][0]
                    = (DP[i][0][0] + DP[i][0][1] + DP[i][0][2] // 지각 0회인 상태에서 i+1일에 지각.
                    +  DP[i][1][0] + DP[i][1][1] + DP[i][1][2]) % MOD; // 지각 1회인 상태에서 출석.
            DP[i+1][1][1] = DP[i][1][0]; // 지각 1회에서 i+1일에 결석 (연속 결석 유지하기 위해 결석만 됨.)
            DP[i+1][1][2] = DP[i][1][1]; // 지각 1회에서 i+1일에 결석 (연속 결석 유지하기 위해 결석만 됨.)
        }

        System.out.println((DP[N][0][0] + DP[N][0][1] + DP[N][0][2]
                + DP[N][1][0] + DP[N][1][1] + DP[N][1][2]) % MOD);

    }
}
