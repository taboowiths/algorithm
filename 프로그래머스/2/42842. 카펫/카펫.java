import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sqrt = (int) Math.sqrt(yellow);
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= sqrt; i++) {
            if (yellow % 1 == 0) {
                list.add(i);
                if (yellow / i != i) list.add(yellow / i);
            }
        }
        list.sort(Comparator.naturalOrder());
        
        int len = list.size();
        int width = 0, height = 0;
        label: for (int i = len/2; i < len; i++) {
            width = list.get(i);
            height = list.get(len-1-i);
            
            int brownCount = (width*2) + (height*2) + 4;
            if (brownCount == brown) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break label;
            }
        }
        
        return answer;
    }
}