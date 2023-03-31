import java.io.*;
import java.util.*;
public class Main {
    static char king_col, stone_col;
    static int king_row, stone_row;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String king = st.nextToken();
        String stone = st.nextToken();
        king_col = king.substring(0, 1).charAt(0); // 킹 열 알파벳
        king_row = Integer.parseInt(king.substring(1, 2)); // 킹 행 숫자
        stone_col = stone.substring(0, 1).charAt(0); // 돌 열 알파벳
        stone_row = Integer.parseInt(stone.substring(1, 2)); // 돌 행 숫자

        int N = Integer.parseInt(st.nextToken());
        String[] move = new String[N];
        for (int i = 0; i < N; i++) {
            move[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            movement(move[i]);
        }
        System.out.println(king_col + "" + king_row);
        System.out.println(stone_col + "" + stone_row);
        br.close();
    }
    public static void movement (String move) {
        switch (move) {
            case "R": // 한 칸 오른쪽 (열+1)
                if (king_col + 1 > 'H') break;
                king_col += 1;
                if (check()) {
                    if (stone_col + 1 > 'H') {
                        king_col -= 1;
                        break;
                    }
                    stone_col += 1;
                }
                break;
            case "L" : // 한 칸 왼쪽
                if (king_col - 1 < 'A') break;
                king_col -= 1;
                if (check()) {
                    if (stone_col - 1 < 'A') {
                        king_col += 1;
                        break;
                    }
                    stone_col -= 1;
                }
                break;
            case "T": // 한 칸 아래
                if (king_row + 1 > 8) break;
                king_row+=1;
                if (check()) {
                    if (stone_row + 1 > 8) {
                        king_row-=1; // 원상복구
                        break;
                    }
                    stone_row+=1;
                }
                break;
            case "B": // 한 칸 위
                if (king_row - 1 < 1) break;
                king_row-=1;
                if (check()) {
                    if (stone_row - 1 < 1) {
                        king_row += 1;
                        break;
                    }
                    stone_row -= 1;
                }
                break;
            case "RT": // 오른쪽 위 (열+1, 행+1)
                if (king_col + 1 > 'H' || king_row + 1 > 8 ) break;
                king_col += 1; king_row += 1;
                if (check()) {
                    if (stone_col + 1 > 'H' || stone_row + 1 > 8) {
                        king_col -= 1; king_row -= 1;
                        break;
                    }
                    stone_col += 1; stone_row += 1;
                }
                break;
            case "LT": // 왼쪽 위 (열-1, 행+1)
                if (king_col - 1 < 'A' || king_row + 1 > 8 ) break;
                king_col -= 1; king_row += 1;
                if (check()) {
                    if (stone_col - 1 < 'A' || stone_row + 1 > 8) {
                        king_col += 1; king_row -= 1;
                        break;
                    }
                    stone_col -= 1; stone_row += 1;
                }
                break;
            case "RB": // 오른쪽 아래 (열+1, 행-1)
                if (king_col + 1 > 'H' || king_row - 1 < 1 ) break;
                king_col += 1; king_row -= 1;
                if (check()) {
                    if (stone_col + 1 > 'H' || stone_row - 1 < 1) {
                        king_col -= 1; king_row += 1;
                        break;
                    }
                    stone_col += 1; stone_row -= 1;
                }
                break;
            case "LB": // 왼쪽 아래 (열-1, 행-1)
                if (king_col - 1 < 'A' || king_row - 1 < 1 ) break;
                king_col -= 1; king_row -= 1;
                if (check()) {
                    if (stone_col - 1 < 'A' || stone_row - 1 < 1) {
                        king_col += 1; king_row += 1;
                        break;
                    }
                    stone_col -= 1; stone_row -= 1;
                }
                break;
        }
    }

    public static boolean check () {
        return stone_row==king_row && Objects.equals(stone_col, king_col);
    }
}
