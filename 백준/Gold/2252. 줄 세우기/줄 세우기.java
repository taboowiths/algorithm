import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] edgeCnt = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            edgeCnt[to]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (edgeCnt[i] == 0) {
                pq.offer(i);
            }
        }
        while (!pq.isEmpty()) {
            int nodeNo = pq.poll();
            sb.append(nodeNo).append(" ");
            for (int i : graph[nodeNo]) {
                edgeCnt[i]--;
                if (edgeCnt[i] == 0) pq.add(i);
            }
        }
        System.out.println(sb);
    }
}
