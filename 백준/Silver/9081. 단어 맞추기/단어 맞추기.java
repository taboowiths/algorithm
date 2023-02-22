import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String test = br.readLine();
            char[] input = test.toCharArray();
            int idx1=-1;
            for (int i = input.length-1; i > 0; i--) {
                if (input[i] > input[i-1]) {
                    idx1 = i-1;
                    break;
                }
            }

            char tmp;
            for (int i = input.length-1; i >= 0; i--)  {
                if (idx1 == -1) break;
                if (input[i] > input[idx1]) {
                    tmp = input[i];
                    input[i] = input[idx1];
                    input[idx1] = tmp;
                    break;
                }
            }

            if (idx1 != -1)Arrays.sort(input, idx1+1, input.length);
            for (int i = 0; i < input.length; i++) sb.append(input[i]);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
