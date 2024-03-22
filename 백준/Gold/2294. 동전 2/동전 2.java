import java.util.*;
import java.io.*;
public class Main {
    static int max = 9999999;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류 개수
        int K = Integer.parseInt(st.nextToken()); // 가치
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] D = new int[K+1];
        for (int i = 1; i <= K; i++) {
            int min = max;
            for (int j = 0; j < N; j++) {
                if (i >= coin[j] && D[i-coin[j]]+1 < min)
                    min = D[i-coin[j]]+1;
            }
            D[i] = min;
        }
        if (D[K] == max) System.out.println(-1);
        else System.out.println(D[K]);
    }
}
