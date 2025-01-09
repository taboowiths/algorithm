
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = 3;

        StringTokenizer st;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] minDp = new int[N][3];
        int[][] maxDp = new int[N][3];

        // dp[i][0]: 0번째 줄로 내려간 경우
        // dp[i][1]: 1번째 줄로 내려간 경우
        // dp[i][2]: 2번재 줄로 내려간 경우

        maxDp[0][0] = map[0][0];
        maxDp[0][1] = map[0][1];
        maxDp[0][2] = map[0][2];

        minDp[0][0] = map[0][0];
        minDp[0][1] = map[0][1];
        minDp[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + map[i][0];
            maxDp[i][1] = Math.max(maxDp[i-1][0], Math.max(maxDp[i-1][1], maxDp[i-1][2])) + map[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + map[i][2];

            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + map[i][0];
            minDp[i][1] = Math.min(minDp[i-1][0], Math.min(minDp[i-1][1], minDp[i-1][2])) + map[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + map[i][2];
        }

        int maxResult = Math.max(maxDp[N-1][0], Math.max(maxDp[N-1][1], maxDp[N-1][2]));
        int minResult = Math.min(minDp[N-1][0], Math.min(minDp[N-1][1], minDp[N-1][2]));
        System.out.println(maxResult + " " + minResult);

    }
}
