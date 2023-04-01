import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int[] alpha = new int[26];
            for (int i = 0; i < s.length(); i++) {
                alpha[s.charAt(i)-'a']++;
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < s.length(); i++) {
                if (alpha[s.charAt(i)-'a'] < K) continue;
                int cnt = 0;
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(j) == s.charAt(i)) cnt++;
                    if (cnt == K) {
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
