import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputs);
        int[] diff = new int[N-1];
        for (int i = 1; i < N; i++) {
            diff[i-1] = inputs[i] - inputs[i-1];
        }
        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < N-K; i++) {
            ans+=diff[i];
        }
        System.out.println(ans);
        br.close();
    }
}
