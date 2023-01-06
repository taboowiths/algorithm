import java.io.*;
import java.util.*;

public class Main {
    static int info[][], N;
    static ArrayList<Integer> arrays;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        info = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        System.out.println(checkCnt(answer));
    }

    public static int checkCnt (int answer) {
        for (int i = 123; i <= 987; i++) { // 전체 수 반복
            String s = Integer.toString(i);
            if (!checkDupl(s)) continue;
            int pass = 0;

            // i랑 info값 비교
            for (int j = 0; j < N; j++) {
                // 비교할 info 값
                String value = Integer.toString(info[j][0]);
                int testStrike = info[j][1];
                int testBall = info[j][2];

                // 현재 뽑힌 값
                int strike = 0;
                int ball = 0;

                // 스트라이크 비교
                for (int k = 0; k < 3; k++) {
                    if (s.charAt(k) == value.charAt(k)) strike++;
                }

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if ((s.charAt(k) == value.charAt(l)) && k != l) ball++;
                    }
                }

                if (strike == testStrike && ball == testBall) {
                    pass++;
                }
            }
            if (pass == N) {
                answer ++;
            }
        }
        return answer;
    }

    public static boolean checkDupl(String value) {
        for (int i = 0; i < 3; i++) {
            if (value.charAt(i) == '0') return false;
        }
        if (value.charAt(0) == value.charAt(1)) return false;
        else if (value.charAt(1) == value.charAt(2)) return false;
        else if (value.charAt(0) == value.charAt(2)) return false;
        return true;
    }
 }
