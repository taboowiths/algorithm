import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] numbers = new long[1001];
        long sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            numbers[(int) (sum % M)]++;
        }

        long ans = 0;
        for (int i = 0; i <= 1000; i++) {
            if (numbers[i]>1) {
                ans += numbers[i] * (numbers[i]-1) / 2;
            }
        }
        System.out.println(numbers[0] + ans);
    }
}
