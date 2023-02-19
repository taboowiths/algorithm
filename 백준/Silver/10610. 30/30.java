import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] input = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            input[i] = s.charAt(i)-'0';
        }
        Arrays.sort(input);
        StringBuilder res = new StringBuilder();
        for (int i = input.length-1; i >= 0; i--) {
            res.append(input[i]);
        }
        if (!res.toString().contains("0")) System.out.println(-1);
        else {
            BigInteger b = new BigInteger(res.toString());
            if (b.remainder(BigInteger.valueOf(3)) != BigInteger.valueOf(0)) System.out.println(-1);
            else System.out.println(res.toString());
        }
    }
}
