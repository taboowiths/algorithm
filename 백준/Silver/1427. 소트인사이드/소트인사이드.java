import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] input = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            input[i] = s.charAt(i)-'0';
        }
        Integer[] reverse = Arrays.stream(input).boxed().toArray(Integer[]::new);
        Arrays.sort(reverse, Collections.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            sb.append(reverse[i]);
        }
        System.out.println(sb.toString());
        br.close();
    }
}