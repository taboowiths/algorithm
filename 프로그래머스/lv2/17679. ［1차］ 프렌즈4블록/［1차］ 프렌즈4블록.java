import java.util.ArrayList;

class Solution {
    public static int solution (int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        searchBlock(m, n, map);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '0') answer++;
            }
        }
        return answer;
    }

    public static void searchBlock (int m, int n, char[][] map) {
        while (true) {
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char item = map[i][j];
                    if (item != '0' && check(i, j, m, n) && map[i][j+1] == item && map[i+1][j] == item && map[i+1][j+1] == item) {
                        list.add(new int[] {i, j});
                        list.add(new int[] {i, j+1});
                        list.add(new int[] {i+1, j});
                        list.add(new int[] {i+1, j+1});
                    }
                }
            }

            if (list.size() == 0) break;

            for (int[] loc : list) {
                map[loc[0]][loc[1]] = '0';
            }

            for (int j = 0; j < n; j++) {
                int i = m-1;
                while (i > 0) {
                    if (map[i][j] == '0') {
                        int ni = i-1;
                        while (ni > 0 && map[ni][j] == '0') ni--;
                        map[i][j] = map[ni][j];
                        map[ni][j] = '0';
                    }
                    i--;
                }
            }

        }
    }
    
    public static boolean check(int i, int j, int m, int n) {
        return j+1 < n && i+1 < m;
    }
    
}