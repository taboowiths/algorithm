package bj;
import java.io.*;
import java.util.*;

public class Main_bj_2739_구구단 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d\n", N, i, N*i);
        }
        br.close();
    }
}
