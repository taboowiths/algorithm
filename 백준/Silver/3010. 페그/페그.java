import java.util.*;
import java.io.*;
public class Main {
    static int N=7, M=7, di[] = {-1, 1, 0, 0}, dj[] = {0, 0, -1, 1};
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int move = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'o') {
                    move += checkMove(i, j);
                }
            }
        }
        System.out.println(move);
        br.close();
    }

    public static int checkMove(int i, int j) {
        int move = 0;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (check(ni, nj) && map[ni][nj] == 'o') { // 범위 내 & 칩 있음.
                int nni = ni + di[d]; // 그 다음칸 확인
                int nnj = nj + dj[d];
                if (check(nni, nnj) && map[nni][nnj] == '.') { // 이동 가능
                    move++;
                }
            }
        }
        return move;
    }

    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < M;
    }
}
