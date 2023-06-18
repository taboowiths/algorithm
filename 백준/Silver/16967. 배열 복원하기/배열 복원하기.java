import java.io.*;
import java.util.*;
public class Main {
    static int H, W, X, Y;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new int[H+X][W+Y];
        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W + Y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (X <= i && Y <= j){
                    map[i][j] = map[i][j]-map[i-X][j-Y];
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
