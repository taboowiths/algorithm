import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int x, y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y) {
                return this.x - o.x;
            } else return this.y - o.y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes);
        for (int i = 0; i < N; i++) {
            sb.append(nodes[i].x).append(" ").append(nodes[i].y).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}