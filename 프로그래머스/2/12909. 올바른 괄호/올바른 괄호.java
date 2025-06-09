import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stk.isEmpty() && ch == ')' && stk.peek() == '(') stk.pop();
            else stk.push(ch);
        }
        
        answer = stk.isEmpty();

        return answer;
    }
}