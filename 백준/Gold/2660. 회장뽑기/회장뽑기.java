import java.io.*;
import java.util.*;

/**
 * 1. 한 점에서 다른 점으로 가는 거리의 최대값 = 점수
 * 2. 점수가 가장 작은 사람이 회장.
 * 3. 회장의 점수, 회장 후보의 수, 회장 후보를 오름차순으로 출력.
 */
public class Main {
    static final int INF = 999999;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N+1][N+1];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from == -1) break;
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && matrix[i][j] == 0) matrix[i][j] = INF;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k) continue;
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k) continue;
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        ArrayList<Integer> min_list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, matrix[i][j]);
            }
            if (min == max) {
                min_list.add(i);
            } else if (min > max) {
                min = max;
                min_list.clear();
                min_list.add(i);
            }
        }
        Collections.sort(min_list);
        sb.append(min).append(" ").append(min_list.size()).append("\n");
        for(int node : min_list) {
            sb.append(node).append(" ");
        }
        System.out.println(sb);
    }
}
