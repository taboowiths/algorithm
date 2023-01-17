import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] input = new boolean[31];

        for (int i = 1; i <= 28; i++) {
            int num = Integer.parseInt(br.readLine());
            input[num] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!input[i]) System.out.println(i);
        }
        br.close();
    }
}