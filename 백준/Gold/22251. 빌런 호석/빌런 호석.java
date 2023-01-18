import java.util.*;
import java.io.*;

public class Main {
    static int numbers[][] = {
            {1, 1, 0, 1, 1, 1, 1}, // 0
            {0, 0, 0, 1, 0, 0, 1}, // 1
            {1, 0, 1, 1, 1, 1, 0}, // 2
            {1, 0, 1, 1, 0, 1, 1}, // 3
            {0, 1, 1, 1, 0, 0, 1}, // 4
            {1, 1, 1, 0, 0, 1, 1}, // 5
            {1, 1, 1, 0, 1, 1, 1}, // 6
            {1, 0, 0, 1, 0, 0, 1}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}, // 9
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // N 이하의 수로 변경 가능 (N 층까지 존재)
        int K = Integer.parseInt(st.nextToken()); // K 자리 수
        int P = Integer.parseInt(st.nextToken()); // 최대 P개 반전
        int X = Integer.parseInt(st.nextToken()); // 현재 멈춰있는 층 수
        int result = 0;

        // 1부터 N 층까지 따짐.
        for (int i = 1; i <= N; i++) {
            StringBuilder str = new StringBuilder();
            str.append(Integer.toString(i));
            while (str.length() < K) {
                str.insert(0, "0");
            }

            StringBuilder X2 = new StringBuilder().append(Integer.toString(X));
            while (X2.length() < K) {
                X2.insert(0, "0");
            }

            int diff = 0;
            for (int j = 0; j < K; j++) { // 자리 수
                for (int k = 0; k < 7; k++) {
                    if (numbers[X2.toString().charAt(j)-'0'][k] != numbers[str.toString().charAt(j)-'0'][k]) {
                        diff++;
                    }
                }
            }
            if (1 <= diff && diff <= P) result++;
        }
        System.out.println(result);
    }
}
