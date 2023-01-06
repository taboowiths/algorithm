import java.util.*;
import java.io.*;

public class Main {
    static int N, M, max, cards[], numbers[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];
        numbers = new int[3];

        max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        comb(0, 0);
        System.out.println(max);
    }

    public static void comb (int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += numbers[i];
            }
            if (sum <= M) max = Math.max(sum, max);
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = cards[i];
            comb(cnt+1, i+1);
        }
    }
}
