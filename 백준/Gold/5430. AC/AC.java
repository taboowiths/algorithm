import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String order = br.readLine(); // 함수
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < N; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            String result = null;
            boolean flag = false; // 앞이 앞
            for (int i = 0; i < order.length(); i++) {
                Character ch = order.charAt(i);
                switch (ch) {
                    case 'R':
                        flag = !flag;
                        break;
                    case 'D':
                        if (!deque.isEmpty()) {
                            if (flag) { // 뒤가 앞
                                deque.pollLast();
                            } else { // 앞이 앞
                                deque.pollFirst();
                            }
                        } else {
                            result = "error";
                            break;
                        }
                        break;
                }
            }
            if (!deque.isEmpty()) {
                sb.append('[');
                while (!deque.isEmpty()) {
                    if (flag) sb.append(deque.pollLast()).append(',');
                    else sb.append(deque.pollFirst()).append(',');
                }
                if (sb.toString().endsWith(",")) {
                    result = sb.toString().substring(0, sb.toString().length() - 1) + "]";
                }
            } else if (result == null) {
                result = "[]";
            }
            System.out.println(result);
        }
    }
}
