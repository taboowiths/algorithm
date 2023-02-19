import java.util.*;
import java.io.*;
public class Main {
    static int N=5, M=9, di[] = {-1, 1, 0, 0}, dj[] = {0, 0, -1, 1}, total, move;
    static char map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            map = new char[N][M];
            total = 0;
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == 'o') total++;
                }
            }
            move = Integer.MAX_VALUE;
            dfs(total);
            System.out.println(move + " " + (total-move));
            br.readLine(); // 공백
        }
        br.close();
    }

    public static void dfs (int cnt) {
        if (cnt < move) move = cnt;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'o') {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if (!check(ni, nj)) continue;
                        if (map[ni][nj] == 'o') {
                            int nni = ni + di[d];
                            int nnj = nj + dj[d];
                            if (!check(nni, nnj)) continue;
                            if (map[nni][nnj] == '.') {
                                map[i][j] = '.';
                                map[ni][nj] = '.';
                                map[nni][nnj] = 'o';
                                dfs(cnt-1);
                                map[i][j] = 'o';
                                map[ni][nj] = 'o';
                                map[nni][nnj] = '.';
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean check(int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
