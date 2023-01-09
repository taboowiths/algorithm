import java.util.*;
import java.io.*;

public class Main {
    static int score[][], max;
    static boolean position[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        score = new int[11][11];
        position = new boolean[11];
        StringTokenizer st;
        sb = new StringBuilder();

        for (int tc = 0; tc < C; tc++) {
            max = 0;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 11; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            setPosition(0, 0);
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    public static void setPosition (int num, int total) {
        if (num == 11) {
            max = Math.max(total, max);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (position[i] || score[num][i] == 0 ) continue;
            position[i] = true;
            setPosition(num + 1, total + score[num][i]);
            position[i] = false;
        }
    }
}
