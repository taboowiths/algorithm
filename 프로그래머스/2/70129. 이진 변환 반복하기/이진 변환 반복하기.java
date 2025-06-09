class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String curStr = s;
        
        while (!curStr.equals("1")) {
            answer[1]+=curStr.length();
            curStr = curStr.replaceAll("0", "");
            answer[1]-=curStr.length();
            curStr = Integer.toBinaryString(curStr.length());
            answer[0]++;
        }
        
        return answer;
        
    }
} 