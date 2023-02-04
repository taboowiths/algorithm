import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] v;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ans = 0;
        g = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }
        v = new boolean[2000];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[from].add(to);
            g[to].add(from);
        }

        for (int i = 0; i < N; i++) {
            v[i] = true;
            dfs(i, 0);
            v[i] = false;
            if (ans == 1) break;
        }
        System.out.println(ans);
        br.close();
    }

    static void dfs (int i, int cnt) {
        if (cnt >= 4) {
            ans = 1;
            return;
        }
        for (int j:g[i]) {
            if (!v[j]) {
                v[j] = true;
                dfs(j, cnt+1);
                v[j] = false;
            }
        }
    }
}
