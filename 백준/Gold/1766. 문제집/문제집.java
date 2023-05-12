import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] edgeCnt = new int[N+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
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
            List<Integer> list = graph.get(nodeNo);
            for (int i = 0; i < list.size(); i++) {
                edgeCnt[list.get(i)]--;
                if (edgeCnt[list.get(i)] == 0) {
                    pq.offer(list.get(i));
                }
            }
        }
        System.out.println(sb);
    }
}
