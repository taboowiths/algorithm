import java.io.*;
import java.util.*;
public class Main {
    static int A, B, C;
    static boolean[][] visited;
    static boolean[] ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        ans = new boolean[201];

        dfs(0, 0, C);

        for (int i = 0; i < 201; i++) {
            if (ans[i]) System.out.print(i + " ");
        }
    }

    public static void dfs (int a, int b, int c) {

        if (visited[a][b]) return;
        if (a == 0) ans[c] = true;
        visited[a][b] = true;

        // a -> b
        if (b+a > B) {
            dfs((b+a)-B, B, c);
        } else {
            dfs(0, b+a, c);
        }

        // c -> a
        if (a+c > A) {
            dfs (A, b, (c+a)-A);
        } else {
            dfs(a+c, b, 0);
        }

        // c -> b
        if (b+c > B) {
            dfs(a, B, (c+b)-B);
        } else {
            dfs(a, b+c, 0);
        }

        // b -> a
        if (a+b > A) {
            dfs(A, (a+b)-A, c);
        } else {
            dfs(a+b, 0, c);
        }

        // a -> c, b -> c
        dfs(0, b, c+a);
        dfs(a, 0, c+b);

    }
}
