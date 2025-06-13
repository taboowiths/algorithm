class Solution {
    public long solution(int n) {
        long answer = fibonacci(n);
        return answer % 1234567;
    }
    
    public static long fibonacci (int n) {
        if (n <= 1) return n;
        
        long[] dp = new long[Math.max(n + 1, 4)];
        dp[2] = 1;
        dp[3] = 2;
        
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }
}