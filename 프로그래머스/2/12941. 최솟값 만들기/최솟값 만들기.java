import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < len; i++) {
            int acc = A[i] * B[len-i-1];
            answer += acc;
        }
        
        return answer;
    }
}