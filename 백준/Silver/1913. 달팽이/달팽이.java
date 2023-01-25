import java.io.*;
import java.util.*;
public class Main {
    static int N, map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int X = Integer.parseInt(br.readLine());
        map = new int[N][N];
        getMap();
        int row = 0, col = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
                if (map[i][j] == X) {
                    row = i+1; col = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(row).append(" ").append(col);
        System.out.println(sb.toString());
        br.close();
    }

    public static void getMap() {
        int num = 1;
        int row = N/2;
        int col = N/2;
        int length = 1;
        map[row][col] = num;

        while (true) {
            for (int i = 0; i < length; i++) {
                map[row--][col] = num++;
            }
            if (num-1 == N*N) break;
            for (int i = 0; i < length; i++) {
                map[row][col++] = num++;
            }
            length++;
            for (int i = 0; i < length; i++) {
                map[row++][col] = num++;
            }
            for (int i = 0; i < length; i++) {
                map[row][col--] = num++;
            }
            length++;
        }
    }
}
