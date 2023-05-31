import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] di={-1, 1, 0, 0}, dj={0, 0, -1, 1}; // 상하좌우
    static ArrayList<int[]> T;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        T = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'T') T.add(new int[] {i, j});
            }
        }
        flag = false;
        int[][] selected = new int[3][2];
        comb(0, 0, selected);
        System.out.println(flag ? "YES" : "NO");

    }

    public static void comb (int cnt, int start, int[][] selected) {
        if (cnt==3) {
            init('O', selected);
            if (checkDir(selected)) flag = true;
            init('X', selected);
            return;
        }
        for (int i = start; i < N*N; i++) {
            int x = i / N;
            int y = i % N;
            if (map[x][y] != 'X') continue;
            selected[cnt] = new int[] {x, y};
            comb(cnt+1, i+1, selected);
        }
    }
    public static boolean checkDir(int[][] selected) {
        for (int[] loc : T) {
            for (int d = 0; d < 4; d++) {
                int i = loc[0];
                int j = loc[1];
                while (true) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if (!check(ni, nj) || map[ni][nj] == 'O') break;
                    if (map[ni][nj] == 'S') return false;
                    i += di[d]; j += dj[d];
                }
            }
        }
        return true;
    }

    public static void init(char value, int[][] selected) {
        for (int k = 0; k < 3; k++) {
            map[selected[k][0]][selected[k][1]] = value;
        }
    }

    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}