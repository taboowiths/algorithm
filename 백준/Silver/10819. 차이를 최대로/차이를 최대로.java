import java.io.*;
import java.util.*;
public class Main {
    static int input[], numbers[], N, max;
    static boolean isSelected[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        numbers = new int[N];
        isSelected = new boolean[N];
        max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(max);
        br.close();
    }

    public static void perm (int cnt) {
        if (cnt == N) {
            max = Math.max(getSum(), max);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            numbers[cnt] = input[i];
            isSelected[i] = true;
            perm(cnt+1);
            isSelected[i] = false;
        }
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < N-1; i++) {
            sum += Math.abs(numbers[i] - numbers[i+1]);
        }
        return sum;
    }
}
