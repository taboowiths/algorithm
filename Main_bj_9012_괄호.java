package bj;
import java.io.*;
import java.util.*;

public class Main_bj_9012_괄호 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_9012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Character> stk = new Stack<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (!stk.empty()){
                    if (ch == ')' && stk.pop() == '(') {
                        continue;
                    } else {
                        stk.add(ch);
                    }
                } else {
                    stk.add(ch);
                }
            }
            if (stk.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
