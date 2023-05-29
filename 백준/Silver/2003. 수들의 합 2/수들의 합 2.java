import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] input = new int[N];
        st = new StringTokenizer(br.readLine(), " ") ;
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int start = 0;
        int end = 0;
        long result = 0;

        while (start < N) {
            if (sum > M || end == N) {
                sum -= input[start];
                start++;
            } else {
                sum += input[end];
                end++;
            }
            if (sum == M) result++;
        }

        System.out.println(result);

    }
}
