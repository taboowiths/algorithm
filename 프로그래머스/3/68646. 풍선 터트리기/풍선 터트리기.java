import java.util.*;
class Solution {
    public int solution(int[] balloons) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < balloons.length; i++) {
            if (balloons[i] < min) {
                min = balloons[i];
                minIdx = i;
            }
        }
        
        int cnt = 2;
        int subMin = balloons[0];
        for (int i = 1; i < minIdx; i++) {
            if (balloons[i] < subMin) {
                subMin = balloons[i];
                cnt++;
            }
        }
        
        subMin = balloons[balloons.length - 1];
        for (int i = balloons.length - 2; i >= minIdx; i--) {
            if (balloons[i] < subMin) {
                subMin = balloons[i];
                cnt++;
            }
        }
            
        
        return cnt;
    }
}