package bj;
import java.io.*;
import java.util.*;

public class Main_bj_2644_촌수계산 {
    static class Node {
        int vertex;
        Node link;
        public Node (int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }
    
    static Node[] edgelist;
    static boolean[] visited;
    static int cnt = -1;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_2644.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정점의 개수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p1 = Integer.parseInt(st.nextToken()); // 촌수를 찾아야 하는 두 사람
        int p2 = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine()); // 간선의 개수
        edgelist = new Node[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgelist[from] = new Node(to, edgelist[from]);
            edgelist[to] = new Node(from, edgelist[to]);
        }
        dfs(p1, p2, 1);
        System.out.println(cnt);
        br.close();
    }

    static void dfs(int start, int dest, int res){
        visited[start]=true;
        for(Node j=edgelist[start]; j!= null; j=j.link){//
            if(visited[j.vertex]) continue;
            if (j.vertex == dest) {
                cnt = res;
                return;
            }
            dfs(j.vertex, dest, res+1);
        }
    }
}
