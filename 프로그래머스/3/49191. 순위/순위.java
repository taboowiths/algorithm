import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] table = new boolean[n+1][n+1];
        // for (int i = 0; i < n; i++) {
        //     int from = results[i][0];
        //     int to = results[i][1];
        //     table[from][to] = true;
        // }
        
        for (int[] result : results) {
            table[result[0]][result[1]] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                // if (i == k) continue; 
                for (int j = 1; j <= n; j++) {
                    // if (i == j || j == k) continue;
                    if (!table[i][j] && table[i][k] && table[k][j]) {
                        table[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (table[i][j] || table[j][i]) cnt++;
            }
            if (cnt == n-1) answer++;
        }
        
        return answer;
    }
}