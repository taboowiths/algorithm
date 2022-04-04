package SWEA;
import java.io.*;
import java.util.*;
public class Solution_d3_3282_01Knapsack_대전_5반_강정현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[] weights = new int[N+1];
            int[] profits = new int[N+1];
            int[][] results = new int[N+1][W+1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                weights[i] = Integer.parseInt(st.nextToken());
                profits[i] = Integer.parseInt(st.nextToken());
            }

            int itemWeight = 0, itemBenefit = 0;
            for (int item = 1; item <= N; item++) {
                itemWeight = weights[item];
                itemBenefit = profits[item];

                for (int weight = 1; weight <= W; weight++) {
                    if (itemWeight <= weight) {
                        results[item][weight] = Math.max(results[item-1][weight],
                                                         itemBenefit + results[item-1][weight-itemWeight]);
                    } else {
                        results[item][weight] = results[item-1][weight];
                    }
                }
            }
            System.out.println("#" + tc + " " + results[N][W]);
        }
        br.close();
    }
}


/*
testcase, N, W, 부피v, 가치c
1
4 5
1 2
3 2
4 4
2 3
*/
