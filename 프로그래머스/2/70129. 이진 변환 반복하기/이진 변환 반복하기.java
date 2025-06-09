class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String curStr = s;
        
        while (!curStr.equals("1")) {
            answer[1]+=countChar(curStr, '0');

            curStr = curStr.replaceAll("0", "");
            curStr = Integer.toBinaryString(curStr.length());
            
            answer[0]++;
        }
        
        return answer;
        
    }
    
    public static int countChar (String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
} 