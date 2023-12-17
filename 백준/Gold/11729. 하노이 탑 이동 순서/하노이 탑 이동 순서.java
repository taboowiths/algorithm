import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dfs(K, 1, 2, 3);
        System.out.println(result);
        System.out.println(sb);
    }

    public static void dfs (int cnt, int start, int mid, int to) {
        if (cnt == 1) {
            result++;
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }
        dfs(cnt-1, start, to, mid);
        result++;
        sb.append(start).append(" ").append(to).append("\n");
        dfs(cnt-1, mid, start, to);
    }
}
