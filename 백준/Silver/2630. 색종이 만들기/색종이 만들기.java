import java.io.*;
import java.util.*;
public class Main {
    static int N, map[][], blue, white;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        blue = 0; white=0;
        dfs(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void dfs (int r, int c, int size) {
        if (check(r, c, size)) {
            if (map[r][c]==0) white++;
            else blue++;
            return;
        }

        int changedSize = size/2;
        dfs(r, c, changedSize);
        dfs(r, c+changedSize, changedSize);
        dfs(r+changedSize, c, changedSize);
        dfs(r+changedSize, c+changedSize, changedSize);
    }

    public static boolean check (int r, int c, int size) {
        if (size == 1) return true;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[r][c] != map[i][j]) return false;
            }
        }
        return true;
    }
}
