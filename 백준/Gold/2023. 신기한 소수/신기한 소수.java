import java.util.*;
import java.io.*;
public class Main {
    static int N, numbers[];
    static boolean isSelected[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        isSelected = new boolean[10];
        sb = new StringBuilder();
        perm(0, "");
        System.out.println(sb.toString());
    }

    public static void perm (int cnt, String s) {
        if (cnt == N) {
            sb.append(s).append("\n");
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (isPrime(Integer.parseInt(s+i))) {
                perm (cnt+1, s+i);
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
