import java.io.*;
import java.util.*;
public class Main {
    static int[] win, tie, lose;
    static int[] teamA = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] teamB = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        win = new int[6];
        tie = new int[6];
        lose = new int[6];
        for (int tc = 0; tc < 4; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int all = 0;

            for (int i = 0; i < 6; i++) {
                win[i] = Integer.parseInt(st.nextToken());
                tie[i] = Integer.parseInt(st.nextToken());
                lose[i] = Integer.parseInt(st.nextToken());
                all += (win[i] + tie[i] + lose[i]);
            }

            if (all == 30) {
                flag = false;
                isPossible(0);
            }
            if (flag) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    public static void isPossible(int time) {
        if (flag) return;

        if (time == 15) {
            flag = true;
            return;
        }

        int A = teamA[time];
        int B = teamB[time];

        if (win[A] > 0 && lose[B] > 0) {
            win[A]--;
            lose[B]--;
            isPossible(time+1);
            win[A]++;
            lose[B]++;
        }

        if (lose[A] > 0 && win[B] > 0) {
            lose[A]--;
            win[B]--;
            isPossible(time+1);
            lose[A]++;
            win[B]++;
        }

        if (tie[A] > 0 && tie[B] > 0) {
            tie[A]--;
            tie[B]--;
            isPossible(time+1);
            tie[A]++;
            tie[B]++;
        }
    }
}
