import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[3];
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (0 < i && i < 100) ans = i;
            if (i == 1000) break;
            else {
                int num = i, k = 0;
                while (num > 0) {
                    input[k] = num % 10;
                    num /= 10;
                    k++;
                }
                if ((input[0] - input[1]) == (input[1] - input[2])) ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
