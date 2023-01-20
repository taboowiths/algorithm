import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int score = 0;
            int cnt = 0;
            for(byte value : br.readLine().getBytes()) {
                if (value == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                score += cnt;
            }
            sb.append(score).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}