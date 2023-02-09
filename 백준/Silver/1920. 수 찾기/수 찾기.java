import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int numbers[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Arrays.sort(numbers);
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(num, 0, N-1));
        }
        br.close();
    }
    public static int binarySearch (int key, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == numbers[mid]) {
                return 1;
            } else if (key < numbers[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
