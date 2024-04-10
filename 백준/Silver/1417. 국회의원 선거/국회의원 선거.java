import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < N; i++) pq.offer(Integer.parseInt(br.readLine()));

        int cnt = 0;
        while (!pq.isEmpty()) {
            if (dasom > pq.peek()) break;
            int top = pq.poll();
            top -= 1; dasom += 1; cnt++;
            pq.offer(top);
        }

        System.out.println(cnt);
    }
}
