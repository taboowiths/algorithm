package bj;
import java.util.*;
import java.io.*;

public class Main_bj_2309_일곱난쟁이 {

    static int[] numbers, dwarf;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input_bj_2309.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dwarf = new int[9];
        numbers = new int[7];

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        comb(0, 0);
        br.close();
    }

    static void comb(int cnt, int start) {
        if (cnt == 7) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if (sum == 100) {
                Arrays.sort(numbers);
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println(numbers[i]);
                }
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            numbers[cnt] = dwarf[i];
            comb(cnt+1, i+1);
        }
    }
}

