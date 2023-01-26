import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i)-97;
            if (alpha[num] == -1) {
                alpha[s.charAt(i)-97] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            sb.append(alpha[i]).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}