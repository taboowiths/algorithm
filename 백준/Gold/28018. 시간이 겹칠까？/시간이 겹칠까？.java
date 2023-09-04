import java.io.*;
import java.util.*;
public class Main {
    static int MAX = 1000001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[MAX+1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            input[S]++;
            input[E+1]--;
        }
        int[] sum = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            sum[i] = sum[i-1] + input[i];
        }
        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (Q-- > 0) {
            System.out.println(sum[Integer.parseInt(st.nextToken())]);
        }
    }
}
