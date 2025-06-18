import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {        
        ArrayList<String> list = new ArrayList<>();
        
        int turn = 1;
        int[] turnCnt = new int[n+1];
        boolean isAllDone = true;
        label: for (int i = 0; i < words.length; i++) {
            turnCnt[turn]++;
            
            if (list.size() > 0) {
                String lastWord = list.get(i-1);
                char lastAlpha = lastWord.charAt(lastWord.length() - 1);
                
                String curWord = words[i];
                char firstAlpha = curWord.charAt(0);
                
                if (lastAlpha != firstAlpha || list.contains(curWord)) {
                    isAllDone = false;
                    break label;
                }
                
            }

            list.add(words[i]);
            
            if (turn == n) turn = 1;
            else turn++;
        } 
        
        int[] answer;
        if (!isAllDone) answer = new int[] { turn, turnCnt[turn] };
        else answer = new int[] { 0, 0 };
        
        return answer;
    }
}