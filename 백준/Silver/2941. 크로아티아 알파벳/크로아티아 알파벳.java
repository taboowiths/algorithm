import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>(Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));
        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '=' || ch == '-' || ch == 'j') {
                if (i > 1 && ch == '=' && s.charAt(i-2) == 'd' && s.charAt(i-1) == 'z') {
                    cnt--;
                }
                else if (i > 0 && set.contains(String.valueOf(s.charAt(i-1)+ String.valueOf(ch)))) {

                } else cnt++;
            } else cnt++;
        }
        System.out.println(cnt);
    }
}
