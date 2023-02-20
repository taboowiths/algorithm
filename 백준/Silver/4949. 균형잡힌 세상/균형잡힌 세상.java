import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while (true) {
            s = br.readLine();
            if (s.equals(".")) break;
            boolean flag = true;
            Stack<Character> stk = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if ('a' <= ch && ch <= 'z'|| 'A' <= ch && ch <= 'Z' || ch == ' ' || ch == '.') continue;
                if (ch == ')' || ch == ']') {
                    if (ch == ')') {
                        if (stk.isEmpty() || stk.peek() != '(') flag = false;
                        else stk.pop();
                    } else {
                        if (stk.isEmpty() || stk.peek() != '[') flag = false;
                        else stk.pop();
                    }
                } else stk.push(ch);
            }
            if (!stk.isEmpty() || !flag) System.out.println("no");
            else System.out.println("yes");
        }
        br.close();
    }
}
