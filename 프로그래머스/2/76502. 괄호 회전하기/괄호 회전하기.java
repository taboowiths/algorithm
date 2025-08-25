import java.util.*;

class Solution {
    public int solution(String s) {        
        int count = 0;
        
        String next = s;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(next)) count++;
            
            next = next.substring(1, next.length()) + next.charAt(0);
        }
        
        return count;
    }
    
    public static boolean isValid (String s) {
        Stack<Character> stk = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (stk.isEmpty()) {
                stk.push(ch);
                continue;
            }
            
            char pk = stk.peek();
            if ((ch == ')' && pk == '(') || 
                (ch == ']' && pk == '[') ||
                (ch == '}' && pk == '{')) {
                stk.pop();
            } else {
                stk.push(ch);
            } 
            
        }

        return stk.isEmpty();
    }
}