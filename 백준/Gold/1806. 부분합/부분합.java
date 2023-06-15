import java.io.*;
import java.util.*;
public class Main {
    static int N, S;
    static int[] numbers;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        long result = Solution();
        if (result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);
    }

    public static long Solution() {
        int left = 0;
        int right = 0;
        long sum = 0;
        long result = Integer.MAX_VALUE;

        while (left < N) {
            if (sum > S || right == N) {
                sum -= numbers[left];
                left++;
            } else {
                sum += numbers[right];
                right++;
            }
            if (sum >= S) {
                result = Math.min(right-left, result);
            }
        }
        return result;
    }
}
