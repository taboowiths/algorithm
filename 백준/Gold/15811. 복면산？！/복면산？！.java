import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] alphaNum, alphaSelected;
    static boolean[] visited, inputs;
    static boolean flag;
    static String fir, sec, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        fir = st.nextToken();
        sec = st.nextToken();
        ans = st.nextToken();

        inputs = new boolean[26];
        N = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (!inputs[ch-'A']) {
                inputs[ch-'A'] = true;
                N++;
            }
        }

        if (N > 10) System.out.println("NO");
        else {
            alphaSelected = new int[N];
            int idx = 0;
            for (int i = 0; i < 26; i++) {
                if (inputs[i]) alphaSelected[idx++] = i;
            }

            alphaNum = new int[26];

            Arrays.fill(alphaNum, -1);
            visited = new boolean[10];
            flag = false;
            perm(0);
            
            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
        br.close();
    }

    public static void perm (int cnt) {
        if (flag) return;
        if (cnt == N) {
            if (isAvail()) flag = true;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            alphaNum[alphaSelected[cnt]] = i;
            perm(cnt+1);
            visited[i] = false;
        }
    }

    public static boolean isAvail () {
        int first = 0, second = 0, answer = 0;

        for (int i = 0; i < fir.length(); i++) {
            first = first * 10 + alphaNum[fir.charAt(i) - 'A'];
        }
        for (int i = 0; i < sec.length(); i++) {
            second = second * 10 + alphaNum[sec.charAt(i)- 'A'];
        }
        for (int i = 0; i < ans.length(); i++) {
            answer = answer * 10 + alphaNum[ans.charAt(i)- 'A'];
        }
        return first + second == answer;
    }
}
