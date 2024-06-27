import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N];
        for (int k = 0; k < N; k++) {
            sum[k] = arr[k];
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) {
                    sum[k] = Math.max(sum[k], sum[i]+arr[k]);
                }
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[N-1]);
    }
}