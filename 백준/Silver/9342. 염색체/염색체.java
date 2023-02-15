import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String regex = "^[A-F]?A+F+C+[A-F]?$";
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            if (s.matches(regex)) System.out.println("Infected!");
            else System.out.println("Good");
        }
        br.close();
    }
}
