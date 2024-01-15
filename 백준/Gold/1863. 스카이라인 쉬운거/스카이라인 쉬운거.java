import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Node> stk = new Stack<>();
        StringTokenizer st;

        int cnt = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            Node cur = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            while (!stk.isEmpty() && stk.peek().y > cur.y) {
                Node top = stk.pop();
                if (!stk.isEmpty() && top.y == stk.peek().y) continue;
                if (top.y == 0) continue;
                cnt++;
            }
            stk.push(cur);
        }

        while (!stk.isEmpty()) {
            Node cur = stk.pop();
            if (!stk.isEmpty() && stk.peek().y == cur.y) continue;
            if (cur.y == 0) continue;
            cnt++;
        }
        System.out.println(cnt);
    }
}
