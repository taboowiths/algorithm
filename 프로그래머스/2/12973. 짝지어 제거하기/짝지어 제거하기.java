import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Deque<Character> stk = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (stk.isEmpty()) stk.push(cur);
            else {
                char peek = stk.peek();
                if (cur == peek) stk.pop();
                else  stk.push(cur);
            }
            
        }
        return stk.isEmpty() ? 1 : 0;
    }
}