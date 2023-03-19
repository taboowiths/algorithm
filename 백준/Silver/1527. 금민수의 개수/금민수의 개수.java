import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt = 0;

        Queue<Long> queue = new ArrayDeque<>();
        queue.offer(4L);
        queue.offer(7L);
        while (!queue.isEmpty()) {
            Long cur = queue.poll();
            if (cur <= B) {
                if (A <= cur) cnt++;
                queue.offer(cur*10+4);
                queue.offer(cur*10+7);
            }
        }

        System.out.println(cnt);

    }
}
