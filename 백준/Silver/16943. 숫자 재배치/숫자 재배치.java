import java.util.*;
import java.io.*;
public class Main {
    static int compare, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        compare = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        perm(A, "");
        if (max == Integer.MIN_VALUE) System.out.println(-1);
        else System.out.println(max);
    }

    public static void perm (String A, String C) {
        int N = A.length();

        if (N == 0) {
            if (C.charAt(0)!='0' && Integer.parseInt(C) < compare) {
                max = Math.max(Integer.parseInt(C), max);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            perm(A.substring(0, i) + A.substring(+i+1), C + A.charAt(i));
        }
    }
}
