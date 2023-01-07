import java.util.*;
import java.io.*;

public class Main {
    static int N, S, ans, num[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
        ans = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        // 합이 0이 되는 경우 -> 공집합이 포함되므로 제거.
        if (S==0) System.out.println(ans-1);
        else System.out.println(ans);
        br.close();
    }

    public static void dfs(int depth, int sum) {
        // 조건 성립
        if (depth == N) { // 끝까지 탐색
            if (sum == S) {
                ans++;
            }
            return;
        }

        dfs(depth + 1, sum + num[depth]);
        dfs(depth + 1, sum);

    }
}
