import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0, 0, map);
    }

    public static void sudoku (int row, int col, int[][] map) {
        if (col == 9) {
            sudoku(row+1, 0, map);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (available(row, col, k, map)) {
                    map[row][col] = k;
                    sudoku(row, col+1, map);
                }
            }
            map[row][col] = 0;
            return;
        }
        sudoku(row, col+1, map);
    }
    public static boolean available (int row, int col, int value, int[][] map) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) {
                return false;
            }
        }

        int ni = (row / 3) * 3;
        int nj = (col / 3) * 3;

        for (int i = ni; i < ni + 3; i++) {
            for (int j = nj; j < nj + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
