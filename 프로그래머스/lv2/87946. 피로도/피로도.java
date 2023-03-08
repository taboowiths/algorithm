class Solution {
    static int N, ans;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        visited = new boolean[N];
        dfs(0, k, dungeons);
        int answer = ans;
        return answer;
    }
    public static void dfs (int cnt, int k, int[][] dungeons) {
        if (cnt > ans) {
            ans = cnt;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (dungeons[i][0] <= k) {
                k-=dungeons[i][0];
                dfs(cnt+1, k, dungeons);
            }
            visited[i] = false;
            k+=dungeons[i][0];
        }
    }
}