import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            // 1. 짝수인 경우 -> 절반 순간이동
            if (n % 2 == 0) {
                n /= 2;
            } else  {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}