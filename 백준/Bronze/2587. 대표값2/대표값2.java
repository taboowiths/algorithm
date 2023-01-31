import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] input = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }
        Arrays.sort(input);
        System.out.println(sum/5);
        System.out.println(input[2]);
        br.close();
    }
}
