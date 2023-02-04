import java.util.*;
import java.io.*;
public class Main {
    public static class Node implements Comparable<Node> {
        int age;
        String name;
        public Node (int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return this.age - o.age;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(nodes);
        for (int i = 0; i < N; i++) {
            sb.append(nodes[i].age).append(" ").append(nodes[i].name).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
