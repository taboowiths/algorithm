import java.util.*;
import java.io.*;
public class Main {
    static class Node implements Comparable<Node> {
        int start, end;
        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end == o.end) return this.start-o.start;
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }
        Collections.sort(list);
        int cnt = 1;
        int last = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start >= last) {
                cnt++;
                last = list.get(i).end;
//                System.out.println("selected: " + list.get(i).start + " " + list.get(i).end);
            }
        }
        System.out.println(cnt);
    }
}
