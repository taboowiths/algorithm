import java.util.*;
    
    
class Solution {
    static int INDEX;
    static ArrayList<String> dictionary;
        public static int[] solution(String msg) {
        dictionary = new ArrayList<>();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 26; i++) {
            dictionary.add(String.valueOf(alpha.charAt(i)));
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        INDEX = -1;
        int idx = 0;
        while (idx < msg.length()) {
            sb.append(msg.charAt(idx));
            if (!isContain(sb.toString())){ // 사전에 없으면
                list.add(INDEX);
                dictionary.add(sb.toString());
                sb = new StringBuilder();
            } else{ // 사전에 있으면
                if (idx == msg.length()-1) {
                    list.add(INDEX);
                }
                idx++;
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static boolean isContain(String s) {
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(s)) {
                INDEX = i+1;
                return true;
            } 
        }
        return false;
    }
}