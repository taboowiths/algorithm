import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCnt = new int[N+1];
        int[] termNum = new int[N+1];
        ArrayList<Integer>[] edgeList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) edgeList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList[from].add(to);
            edgeCnt[to]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = N;
        for (int i = 1; 0 < total; i++) {
            for (int j = 1; j <= N; j++) {
                if (edgeCnt[j] == 0 && termNum[j] == 0) pq.offer(j);
            }
            while(!pq.isEmpty()) {
                int num = pq.poll();
                termNum[num] = i;
                for (int edge : edgeList[num]) {
                    edgeCnt[edge]--;
                }
                total--;
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(termNum[i]).append(" ");
        }
        System.out.println(sb);
    }
}
