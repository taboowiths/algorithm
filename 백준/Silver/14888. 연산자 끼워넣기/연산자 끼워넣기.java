import java.io.*;
import java.util.*;

public class Main {
    static int max, min, N;
    static int[] numbers, exp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        exp = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            exp[i] = Integer.parseInt(st.nextToken());
        }
        max=Integer.MIN_VALUE; min=Integer.MAX_VALUE;
        dfs(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    public static void dfs (int cnt, int val) {
        if (cnt == N) {
            max= Math.max(max, val);
            min= Math.min(min, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (exp[i] > 0) {
                exp[i]--;
                if (i==0) dfs(cnt+1, val+numbers[cnt]);
                else if (i==1) dfs(cnt+1, val-numbers[cnt]);
                else if(i==2) dfs(cnt+1, val*numbers[cnt]);
                else dfs(cnt+1, val/numbers[cnt]);
                exp[i]++;
            }
        }
    }
}
