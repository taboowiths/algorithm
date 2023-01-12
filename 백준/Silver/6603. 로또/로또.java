import java.util.*;
import java.io.*;
public class Main {
    static int k, input[], numbers[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        String s;
        while (!Objects.equals(s = br.readLine(), "0")) {
            st = new StringTokenizer(s, " ");
            k = Integer.parseInt(st.nextToken());
            input = new int[k];
            numbers = new int[6];
            for (int i = 0; i < k; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    public static void comb (int cnt, int start) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            numbers[cnt] = input[i];
            comb(cnt+1, i+1);
        }
    }
}
