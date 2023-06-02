import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        System.out.println(isPair(arr, X));
    }

    public static int isPair (int[] arr, int X) {
        int left = 0;
        int right = arr.length - 1;
        int cnt = 0;

        while (left < right) {
            if (arr[left] + arr[right] == X) {
                cnt++;
                left++;
                right--;
            }
            else if (arr[left] + arr[right] > X) right--;
            else left++;
        }
        return cnt;
    }
}
