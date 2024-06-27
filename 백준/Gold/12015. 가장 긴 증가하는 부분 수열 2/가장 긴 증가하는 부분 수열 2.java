import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];
        int len = 0; // dp의 마지막 값
        int idx = 0; // 새로운 값(arr[i])이 들어갈 위치
        for (int i = 0; i < N; i++) {
            if (arr[i] > dp[len]) {
                dp[++len] = arr[i];
            } else {
                idx = binarySearch(0, len, arr[i]);
                dp[idx] = arr[i];
            }
        }
        System.out.println(len);
    }

    public static int binarySearch (int start, int end, int target) {
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (dp[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
