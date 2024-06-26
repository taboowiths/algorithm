import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] inc = new int[N];
        for (int k = 0; k < N; k++) {
            inc[k] = 1;
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) inc[k] = Math.max(inc[k], inc[i]+1);
            }
        }

        int[] dec = new int[N];
        for (int k = N-1; k >= 0; k--) {
            dec[k] = 1;
            for (int i = N-1; i >= k; i--) {
                if (arr[i] < arr[k]) dec[k] = Math.max(dec[k], dec[i]+1);
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, inc[i] + dec[i] - 1);
        }
        System.out.println(result);

    }
}
