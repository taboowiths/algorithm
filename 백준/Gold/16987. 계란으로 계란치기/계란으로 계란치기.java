import java.util.*;
import java.io.*;
public class Main {
    public static class Egg {
        int dur, weight;
        public Egg (int dur, int weight) {
            this.dur = dur;
            this.weight = weight;
        }
    }
    static int N, max;
    static Egg[] eggs;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        max = Integer.MIN_VALUE;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        dfs(0);
        System.out.println(max);
        br.close();
    }

    public static void dfs (int cnt) {
        if (cnt == N) {
            int rest = 0;
            for (Egg egg : eggs) {
                if (egg.dur <= 0) rest++;
            }
            max = Math.max(rest, max);
            return;
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (i == cnt) continue;
            if (eggs[i].dur > 0 && eggs[cnt].dur > 0) { // 고른 두 계란 다 칠 수 있음.
                flag = true;
                eggs[i].dur -= eggs[cnt].weight;
                eggs[cnt].dur -= eggs[i].weight;
                dfs (cnt+1);
                eggs[i].dur += eggs[cnt].weight;
                eggs[cnt].dur += eggs[i].weight;
            }
        }
        if (!flag) dfs(cnt+1);
    }
}
