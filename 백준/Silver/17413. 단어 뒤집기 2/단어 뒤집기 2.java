import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        Stack<Character> stk = new Stack<>();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                if (!stk.isEmpty()) {
                    while (!stk.isEmpty()) sb.append(stk.pop());
                }
                idx = i;
                sb.append(s.charAt(idx));
                while (s.charAt(idx) != '>') sb.append(s.charAt(++idx));
                i = idx;
            } else {
                if (s.charAt(i) == ' ') {
                    while (!stk.isEmpty()) sb.append(stk.pop());
                    sb.append(" ");
                } else {
                    stk.push(s.charAt(i));
                }
            }
        }
        while (!stk.isEmpty()) sb.append(stk.pop());
        System.out.println(sb.toString());
        br.close();
    }
}
