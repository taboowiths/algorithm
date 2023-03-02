import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(0, "", N);
    }

    public static void dfs (int cnt, String s, int N) {
        if (cnt == N) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (check(s+i)) {
                dfs (cnt+1, s+i, N);
            }
        }
    }
    public static boolean check (String s) {
        for (int i = 1; i <= s.length()/2; i++) {
            String test = s.substring(s.length()-i);
            String pre = s.substring(s.length()-2*i, s.length()-i);
            if (test.equals(pre)) return false;
        }
        return true;
    }
}
