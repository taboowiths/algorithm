import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int start = 0;
        int end = array.length - 1;
        int cnt = 0;

        while (start < end) {
            if (array[start] + array[end] > target) {
                end--;
            } else if (array[start] + array[end] < target) {
                start++;
            } else if (array[start] + array[end] == target) {
                cnt++;
                start++;
            }
        }
        System.out.println(cnt);
    }
}
