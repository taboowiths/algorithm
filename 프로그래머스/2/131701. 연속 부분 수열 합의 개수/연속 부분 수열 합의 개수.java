import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length * 2;
        int[] line = new int[len];
        int[] acc = new int[len];
        acc[0] = elements[0];
        
        for (int i = 0; i < len; i++) {
            if (i >= elements.length) line[i] = elements[i-elements.length]; 
            else line[i] = elements[i];
             
            if (i > 0) acc[i] = acc[i-1] + line[i]; 
        }
                
        HashSet<Integer> set = new HashSet<>();
        for (int k = 1; k <= elements.length; k++) { 
            // 길이가 k인 구간
            for (int i = 0; i < elements.length; i++) {
                int total = acc[i+k] - acc[i];
                set.add(total);
            }
        }
        return set.size();
    }
}