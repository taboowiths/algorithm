import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        int wordsLength = words[0].length();
        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            loop2: for (int j = i + 1; j < N; j++) {
                char[] alpha = new char[27];
                loop3: for (int k = 0; k < wordsLength; k++) {
                    int idx = words[i].charAt(k) - 96; // 소문자 -> 인덱스
                    if (alpha[idx] == '\0') {
                        for (int l = 0; l < alpha.length; l++) {
                            if (words[j].charAt(k) == alpha[l]) continue loop2;
                        }
                        alpha[idx] = words[j].charAt(k);
                    }
                    else if (alpha[idx] != words[j].charAt(k)) continue loop2;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
