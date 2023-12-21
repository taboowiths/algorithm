import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        Stack<Long> left = new Stack<>();
        Stack<Long> right = new Stack<>();
        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            left.push(Long.parseLong(st.nextToken()));
        }
        list.add((long) -1);
        right.push(left.pop());

        boolean last = false;
        while (!left.isEmpty()) {
            long cur = left.pop();
            if (left.isEmpty()) last = true;

            if (cur < right.peek()) list.add(right.peek());
            else {
                while (!right.isEmpty()) {
                    long rightCur = right.peek();
                    if (cur < rightCur) break;
                    else right.pop(); //4 3 2 1 2 3 4 // 1 8 5 7 9 // 1 8 5 7 8
                }
                if (right.isEmpty()) {
                    right.push(cur);
                    list.add((long) -1);
                } else {
                    list.add(right.peek());
                }
            }

            if (!last) if (cur > left.peek()) right.push(cur);

        }
        Collections.reverse(list);
        for (long i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
