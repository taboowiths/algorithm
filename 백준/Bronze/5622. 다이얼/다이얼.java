import java.io.*;
import java.util.*;

public class Main {
    static String[] numbers = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 2; j <= 9; j++) {
                if (numbers[j].contains(String.valueOf(s.charAt(i)))) {
                    ans += (j+1);
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}