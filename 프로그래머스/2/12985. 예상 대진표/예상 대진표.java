class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int newA = a;
        int newB = b;
        
        while (newA != newB) {
            newA = (newA + 1) / 2;
            newB = (newB + 1) / 2;
            answer++;
        }
        
        return answer;
    }
}