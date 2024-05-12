import java.util.*;
import java.io.*;

public class Main {
    static int N = 3;
    static int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1};
    static Map<String, Integer> map;
    static String answer = "123456780";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String init = "";
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) init += st.nextToken();
        }
        map = new HashMap<>();
        map.put(init, 0);
        System.out.println(bfs(init));
    }

    public static int bfs(String init) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(init);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int curMove = map.get(cur);
            if (cur.equals(answer)) return curMove;

            int curIdx = cur.indexOf('0');
            int ci = curIdx % 3;
            int cj = curIdx / 3;

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if (ni < 0 || ni >= N || nj < 0 || nj >= N ) continue;

                int newIdx = nj * 3 + ni;
                // swipe
                char ch = cur.charAt(newIdx);
                String next = cur.replace(ch, 'c');
                next = next.replace('0', ch);
                next = next.replace('c', '0');

                if (!map.containsKey(next)) {
                    queue.offer(next);
                    map.put(next, curMove + 1);
                }
            }
        }
        return -1;
    }
}