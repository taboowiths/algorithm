import java.util.*;
import java.io.*;
public class Main {
    static int N, M, H, L, ans, map[][], start[];
    static boolean visited[][];
    static ArrayList<int[]> milk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 초기 체력
        H = Integer.parseInt(st.nextToken()); // 체력 증가
        map = new int[N][N];
        milk = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    start = new int[] {i, j};
                } else if (map[i][j] == 2) milk.add(new int[] {i, j});
            }
        }
        L = milk.size();
        boolean[] visited = new boolean[L];
        ans = 0;
        dfs(start, 0, M, visited);
        System.out.println(ans);
        br.close();
    }

    public static void dfs (int[] cur, int cnt, int hp, boolean[] visited) {
        if (hp >= getDist(cur, start)) {
            ans = Math.max(ans, cnt);
        }
        for (int i = 0; i < L; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (hp >= getDist(cur, milk.get(i))) {
                    dfs (milk.get(i), cnt+1, (hp+H-getDist(cur, milk.get(i))), visited);
                }
                visited[i] = false;
            }
        }
    }

    public static int getDist (int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}
