
import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;
    static int[] col;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new int[N+1];
        cnt = 0;
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs (int cur) {
        if (!isAvailable(cur-1)) return;
        if (cur > N) {
            cnt++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            col[cur] = i;
            dfs(cur+1);
        }
    }

    public static boolean isAvailable (int cur) {
        for (int i = 1; i < cur; i++) {
            if (col[cur] == col[i] || cur - i == Math.abs(col[cur] - col[i])) return false;
        }
        return true;
    }
}
