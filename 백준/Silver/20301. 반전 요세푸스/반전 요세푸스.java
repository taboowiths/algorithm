import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        int turn = 0;
        boolean dir = false; // 0: 오른쪽, 1: 왼쪽
        while (!queue.isEmpty()) {
            if (cnt == K) { // K번째 사람 제거
                if (!dir) sb.append(queue.pollLast());
                else sb.append(queue.pollFirst());
                sb.append("\n");
                turn++;
                cnt = 0;
                continue;
            }

            if (turn == M) { // M명 제거
                dir = !dir; // 방향 바꿈
                turn = 0;
                continue;
            }

            if (!dir)queue.offerLast(queue.pollFirst()); // 맨 앞 -> 맨 뒤
            else queue.offerFirst(queue.pollLast());
            cnt++;
        }

        System.out.println(sb.toString());
        br.close();

    }
}
