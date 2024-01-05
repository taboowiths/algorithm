import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = 4;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.offer(Integer.parseInt(st.nextToken()));
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int tmp = 0;
            deque.addLast(deque.pollFirst());
            for (int j = 0; j < N; j++) {
                int num = deque.getLast();
                if (j == 0) tmp += num;
                else tmp += (int) (num * Math.pow(10, j));
                deque.addFirst(deque.pollLast());
            }
            min = Math.min(min, tmp);
        }
        System.out.println(getNumberOfCircle(min));
        br.close();
    }

    public static int getNumberOfCircle (int minValue) {
        int cnt = 0;
        for (int i = 1111; i <= minValue; i++) {
            if (isCircle(i) == i) cnt++;
        }
        return cnt;
    }

    public static int isCircle (int checkNum) {
        int temp = checkNum;
        for (int i = 0; i < 3; i++) {
            checkNum = checkNum % 1000 * 10 + checkNum / 1000;
            if (temp > checkNum) temp = checkNum;
        }
        return temp;
    }
}
