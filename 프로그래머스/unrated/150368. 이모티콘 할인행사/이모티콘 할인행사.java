class Solution {
    static int[] DISCOUNT = {10, 20, 30, 40};
    static int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
    public static int[] solution(int[][] users, int[] emoticons) {
        int ELen = emoticons.length;

        int[] percents = new int[ELen];

        getPercents(0, ELen, percents, users, emoticons);
        int[] answer = new int[] {max[0], max[1]};
        return answer;
    }
    
    public static void getPercents (int cnt, int N, int[] percents, int[][] users, int[] emoticons) {
        if (cnt == N) {
            int[] result = calcPercent(users, percents,emoticons);
            if (result[0] > max[0]) { // 가입자 같거나 많으면
                max[0] = result[0];
                max[1] = result[1];
            } else if (result[0] == max[0]) {
                max[1] = Math.max(result[1], max[1]);
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            percents[cnt] = DISCOUNT[i];
            getPercents(cnt+1, N, percents, users, emoticons);
        }
    }
    
    public static int[] calcPercent (int[][] users, int[] percents, int[] emoticons) {
        int sum = 0;
        int members = 0;
        for (int i = 0; i < users.length; i++) {
            int buy = 0;
            for (int j = 0; j < percents.length; j++) {
                if (users[i][0] > percents[j]) continue; // user 의
                buy += (emoticons[j] - (emoticons[j] * percents[j]*0.01));
            }
            // 기준치보다 높다면 -> 플러스 가입, 아니면 -> 총액에 합함
            if (buy >= users[i][1])  members++;
            else sum += buy;
        }
        return new int[] {members, sum};
    }
}