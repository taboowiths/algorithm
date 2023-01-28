import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            boolean[] alpha = new boolean[26];
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!alpha[ch-97]) {
                    alpha[ch-97] = true;
                } else {
                    if (ch != s.charAt(j-1)) flag = false; // 그룹단어 아님
                }
            }
            if (flag) ans++;
        }
        System.out.println(ans);
        br.close();
    }
}
