import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(people);
        
        for (int i = 0; i < people.length; i++) {
            deque.offer(people[i]);
        }
        
        while (!deque.isEmpty()) {
            if (deque.size() != 1) {
                int head = deque.getLast();
                int tail = deque.getFirst();

                // 무게 제한 이내인 경우
                if (head + tail <= limit) {
                    deque.pollFirst();
                }
            }
            deque.pollLast();
            answer++;
        }
            
        return answer;
    }
}