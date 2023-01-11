import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans, kits[], numbers[];
    static boolean isSelected[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 운동 키트 개수
        K = Integer.parseInt(st.nextToken()); // 감소하는 중량
        kits = new int[N];
        numbers = new int[N];
        isSelected = new boolean[N];
        ans = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 500);
        System.out.println(ans);
        br.close();
    }

    public static void dfs (int cnt, int sum) {
        if (sum < 500) return;

        if (cnt == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            numbers[cnt] = kits[i];
            isSelected[i] = true;
            dfs(cnt+1, sum - K + numbers[cnt]);
            isSelected[i] = false;
        }
    }

}
