import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        if (!Character.isLetter(s.charAt(0))) sb.append(s.charAt(0));
        else sb.append(Character.toUpperCase(s.charAt(0)));
        
        for (int i = 1; i < s.length(); i++) {            
            char cur = s.charAt(i);
            if (s.charAt(i-1) != ' ') { // 공백이 아닌 경우 -> 일반 글자
                sb.append(Character.toLowerCase(cur));
            } else { // 공백인 경우 -> 숫자/대문자 OR 소문자  
                if (Character.isDigit(cur) || Character.isUpperCase(cur)) {
                    sb.append(cur);
                    continue;
                }
                sb.append(Character.toUpperCase(cur));
            }
        }
        
        return sb.toString();
    }
}