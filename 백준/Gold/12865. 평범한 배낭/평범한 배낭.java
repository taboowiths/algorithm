import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N+1];
        int[] profits = new int[N+1];
        int[][] results = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        int itemWeight = 0, itemBenefit = 0;
        for (int item = 1; item <= N; item++) {
            itemWeight = weights[item];
            itemBenefit = profits[item];

            for (int weight = 1; weight <= K; weight++) {
                if (itemWeight <= weight) {
                    results[item][weight] = Math.max(results[item-1][weight], itemBenefit + results[item-1][weight-itemWeight]);
                } else {
                    results[item][weight] = results[item-1][weight];
                }
            }
        }
        System.out.println(results[N][K]);
    }
}
