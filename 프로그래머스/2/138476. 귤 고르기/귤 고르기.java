import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.merge(tangerine[i], 1, (value, putValue) -> value + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));
        
        int total = 0;
        int answer = 0;
        for(Map.Entry<Integer, Integer> item : list){
            if (total + item.getValue() >= k) {
                answer++;
                break;
            } 
                total += item.getValue();
                answer++;
            

        }

        
        
        
        return answer;
    }
}