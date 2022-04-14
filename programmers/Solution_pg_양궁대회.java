package study;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.*;
import java.io.*;
public class Solution_pg_양궁대회 {

    static int n = 9, max, score;// 화살 수
    static int[] info = {0,0,1,2,0,1,1,1,1,1,1};
    static int[] result, numbers, max_result;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        result = new int[11]; // 0 ~ 10
        numbers = new int[n];
        max = Integer.MIN_VALUE;
        flag = false;
        comb(0, 0);
        if (flag) {
            System.out.println(Arrays.toString(max_result));
        } else System.out.println(-1);
    }

    static void comb (int cnt, int start) {
        if (cnt == n) {
            int[] reverseArr = new int[11];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 11; j++) {
                    if (numbers[i] == j) result[j]++;
                }
            }
            for (int i = result.length - 1, j = 0; i >= 0; i--, j++) {
                reverseArr[j] = result[i];
            }
            calc(reverseArr);
            result = new int[11];
            return;
        }
        for (int i = start; i < 11; i++) {
            numbers[cnt] = i;
            comb (cnt+1, i);
        }
    }

    static void calc (int[] lion) {
        int Ascore = 0;
        int Lscore = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && lion[i] == 0) continue;
            if (info[i] > lion[i])  Ascore += (10-i);
            else if (info[i] == lion[i] && info[i] != 0 && lion[i] != 0) Ascore += (10-i);
            else if (info[i] < lion[i]) Lscore += (10-i);
        }
        if (Lscore > Ascore) {
            flag = true;
            if (Lscore - Ascore > max) {
                max = Lscore - Ascore;
                max_result = lion;
            }
        }
    }
}
