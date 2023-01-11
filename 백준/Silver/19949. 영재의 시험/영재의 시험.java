import java.util.*;
import java.io.*;
public class Main {
    static int answer[], numbers[], ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        answer = new int[10];
        numbers = new int[10];
        ans = 0;
        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(ans);
    }
    public static void dfs (int cnt) {
        if (cnt == 10) {
            if (getScore() >= 5) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            numbers[cnt] = i;
            if (cnt > 1) {
                if (!isAvailable(cnt)) continue;
            }
            dfs(cnt+1);
        }
    }

    public static boolean isAvailable (int cnt) {
        return numbers[cnt - 2] != numbers[cnt] || numbers[cnt - 1] != numbers[cnt];
    }

    public static int getScore () {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if (numbers[i] == answer[i]) score++;
        }
        return score;
    }
}
