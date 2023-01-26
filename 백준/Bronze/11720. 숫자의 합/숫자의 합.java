import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += s.charAt(i)-'0';
        }
        System.out.println(result);
        br.close();
    }
}