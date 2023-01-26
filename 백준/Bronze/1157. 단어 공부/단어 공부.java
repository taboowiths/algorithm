import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String s = br.readLine();
        String test = s.toLowerCase();

        for (int i = 0; i < test.length(); i++) {
            char ch = test.charAt(i);
            alpha[ch-97]++;
        }

        int result = checkValue(alpha);
        if (result == -1) {
            System.out.println('?');
        } else {
            String ans = String.valueOf((char)(result+97));
            System.out.println(ans.toUpperCase());
        }
        br.close();
    }

    public static int checkValue (int[] alpha) {
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        // 최대값 확인
        for (int i = 0; i < 26; i++) {
            if (alpha[i] > max) {
                maxIdx = i;
                max = alpha[i];
            }
        }
        // 중복 확인
        for (int i = 0; i < 26; i++) {
            if (i != maxIdx && alpha[i] == max) {
                return -1;
            }
        }
        return maxIdx;
    }
}