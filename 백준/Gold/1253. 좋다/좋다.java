import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (findSum(input[i], i, input)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean findSum(int num, int idx, int[] input) {
        int left = 0;
        int right = input.length-1;
        while (left < right) {
            if (right == idx || input[left] + input[right] > num) right--;
            else if (left == idx || input[left] + input[right] < num) left++;
            else if (input[left] + input[right] == num) return true;
        }
        return false;
    }
}
