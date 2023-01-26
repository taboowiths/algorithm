import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String s = br.readLine();
        String test = s.toUpperCase();

        for (int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            alpha[ch-'A']++;
        }

        int max = -1;
        char ans = '?';
        for (int i = 0; i < 26; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                ans = (char) (i+65);
            } else if (alpha[i] == max) {
                ans = '?';
            }
        }
        System.out.println(ans);
        br.close();
    }
}