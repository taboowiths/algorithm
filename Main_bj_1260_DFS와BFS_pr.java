package bj;
import java.io.*;
import java.util.*;

public class Main_bj_1260_DFS와BFS_pr {

    static class Node implements Comparable<Node> {
        int vertex;
        Node link;
        public Node(int vertex, Node link){
            this.vertex=vertex;
            this.link=link;
        }
        @Override
        public int compareTo(Node o) {
            return this.link.vertex - o.link.vertex;
        }
    }

    static int N, E, V;
    static Node[] edgelist;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input_bj_1260.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        edgelist = new Node[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgelist[from]=new Node(to, edgelist[from]);
            edgelist[to] = new Node(from, edgelist[to]);
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }
    static void dfs (int i) {
        visited[i] = true;
        System.out.print(i + " ");
        for (Node j = edgelist[i]; j != null; j = j.link) {
            if (visited[j.vertex]) continue;
            dfs(j.vertex);
        }
    }

    static void bfs (int i){
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N+1];
        visited[i] = true;
        queue.offer(i);
        while (!queue.isEmpty()) {
            i = queue.poll();
            System.out.print(i + " ");
            for (Node j = edgelist[i]; j != null; j = j.link) {
                if (visited[j.vertex]) continue;
                visited[j.vertex] = true;
                queue.offer(j.vertex);
            }
        }
    }

    class Com implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.vertex, o2.vertex);
        }
    }
}
