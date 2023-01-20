import java.util.*;
import java.io.*;
public class Main {

    static int[][] map;
    static boolean end;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        for (int i = 0; i < 9 ; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j) -'0';
            }
        }
        sudoku(0, 0);
    }

    static void sudoku (int row, int col) {
        if (col == 9) {
            sudoku (row+1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (map[row][col] == 0) {
            for (int t = 1; t <= 9; t++) {
                if (available(row, col, t)) {
                    map[row][col] = t;
                    sudoku(row, col+1);
                }
            }
            map[row][col] = 0;
            return;
        }
        sudoku(row, col+1);
    }

    static boolean available (int row, int col, int target) {
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == target) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (map[row][i] == target) return false;
        }


        int ni = row/3*3;
        int nj = col/3*3;
        for (int r = ni; r < ni+3; r++) {
            for (int c = nj; c < nj+3; c++) {
                if (map[r][c] == target) return false;
            }
        }
        return true;
    }
}
