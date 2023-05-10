import java.util.*;
import java.io.*;
public class Main {
    static class Node implements Comparable<Node> {
        int t, s;
        public Node (int t, int s) {
            this.t = t; // 걸리는 시간
            this.s = s; // 끝내야 하는 시간
        }

        @Override
        public int compareTo(Node o) {
            return this.s - o.s;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] todos = new Node[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            todos[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(todos);

        int start = todos[0].s - todos[0].t;
        int time = todos[0].s;
        for (int i = 1; i < N; i++) {
            int cur = time + todos[i].t; // 걸리는 시간
            if (cur > todos[i].s) {
                start -= (cur - todos[i].s);
                time = todos[i].s;
            } else {
                time += todos[i].t;
            }
        }
        if (start >= 0) System.out.println(start);
        else System.out.println(-1);
    }
}
