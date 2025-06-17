class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            answer = lcm(arr[i], answer);
        }
        return answer;
    }
    
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}