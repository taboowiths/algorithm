import java.util.*;
import java.io.*;
public class Main {
    static int N, di[] = {0, -1, -1, -1, 0, 1, 1, 1}, dj[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        int land = (N-2)*(N-2);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if (i == 1 || j == 1 || i == N-2 || j == N-2) { // 모서리 옆 지뢰 확인
                    if (checkLand(i, j)) findLand(i, j);
                    else land--;
                }
            }
        }
        if (N <= 2) land = 0;
        System.out.println(land);
        br.close();
    }

    public static boolean checkLand (int i, int j) {
        for (int d = 0; d < 8; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (!check(ni, nj)) continue;
            if (map[ni][nj] == '0') return false;
        }
        return true;
    }

    public static void findLand (int i, int j) {
        for (int d = 0; d < 8; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (!check(ni, nj)) continue;
            if (map[ni][nj] >= '0' && map[ni][nj] <= '9') map[ni][nj]--;
        }
    }

    public static boolean check(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}
