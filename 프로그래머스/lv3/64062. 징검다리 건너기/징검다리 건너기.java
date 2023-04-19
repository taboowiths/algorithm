import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max=200000000, min=1;
        
        while (min <= max) {
            int mid = (min + max) / 2;
            // System.out.println("탐색: " + mid);
            if (!isAvailable(stones, k, mid)) {
                max=mid-1;
            } else {
                min=mid+1;
            }
            // System.out.println("max, min: " + max + ", " + min);

        }
        // System.out.println(max);
        return min;
    }
    
    
    public boolean isAvailable(int[] stones, int k, int mid) {
        int cnt = 0;
        for (int i=0; i<stones.length; i++) {
            if (stones[i]-mid <= 0) cnt++; 
            else cnt=0;
            if (cnt == k) return false;
        }
        return true;
    }
}

