import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int[] input = new int[11];
        int cnt = 0;
        for (int i = 1; i <= 10; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= 10; i++) {
            set.add(input[i] % 42);
        }

        System.out.println(set.size());
        br.close();
    }
}


