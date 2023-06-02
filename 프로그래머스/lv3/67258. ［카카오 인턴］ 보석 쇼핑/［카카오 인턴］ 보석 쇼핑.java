import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        return getGems(gems);
    }
    
    public static int[] getGems(String[] gems) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String s : gems) {
            set.add(s);
        }
        int kinds = set.size();
        
        int left = 0;
        int right = 0;
        map.put(gems[0], 1);
        int[] ans = {1, gems.length};
        
        while (left <= right && right < gems.length) {
            if (map.size() == kinds) {
                if (ans[1]-ans[0] > right-left) {
                    ans = new int[] {left+1, right+1};
                }
                map.put(gems[left], map.get(gems[left])-1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
            else if (map.size() < kinds) {
                right++;
                if (right >= gems.length) break;
                if (!map.containsKey(gems[right])) map.put(gems[right], 1);
                else map.put(gems[right], map.get(gems[right])+1);
            }
        }
        return ans;
    }
    
}