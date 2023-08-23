class Solution {
    static int N = 5;
    static int[] di={0, 0, -1, 1}, dj={-1, 1, 0, 0};
    static boolean flag;
    public static int[] solution(String[][] places) {
        int[] answer = new int[N];
        for (int T = 0; T < N; T++) {
            boolean[][] visited = new boolean[N][N];
            flag = false;
            label: for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(places[T][i].charAt(j) == 'P') // 응시자
                        dfs(i, j, 0, visited, places, T);
                    if (flag) {
                        answer[T] = 0;
                        break label;
                    }
                }
            }
            if (!flag) answer[T] = 1;
        }
        return answer;
    }
    
    public static void dfs (int i, int j, int cnt, boolean[][] visited, String[][] places, int T) {
        visited[i][j] = true;
        if (cnt >= 2) return;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (!checkArea(ni, nj) || visited[ni][nj]) continue;
            char next = places[T][ni].charAt(nj);
            if (next == 'X') continue;
            if (next == 'P') {
                flag = true;
                return;
            }
            dfs(ni, nj, cnt+1, visited, places, T);
        }
    }
    
    public static boolean checkArea (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}