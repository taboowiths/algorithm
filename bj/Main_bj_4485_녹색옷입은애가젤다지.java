package bj;
import java.io.*;
import java.util.*;
public class Main_bj_4485_녹색옷입은애가젤다지 {

    static class Node implements Comparable<Node> {
        int x, y, weight;
        public Node (int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, map[][], dist[][];
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/input_bj_4485.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while (true) { // input 받아오는거. 헷갈리지 말 것.
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[0][0] = map[0][0];
            pq.offer(new Node (0, 0, dist[0][0]));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                for (int d = 0; d < 4; d++) {
                    int ni = cur.x + di[d];
                    int nj = cur.y + dj[d];
                    if (check(ni, nj)) {
                        int weight = cur.weight + map[ni][nj];
                        if (dist[ni][nj] > weight) {
                            dist[ni][nj] = weight;
                            pq.offer(new Node(ni, nj, dist[ni][nj]));
                        }
                    }
                }
            }
            System.out.println("Problem " + cnt + ": " + dist[N-1][N-1]);
            cnt++;
        }
        br.close();
    }


    public static boolean check(int i, int j) {
        if (0 <= i && i < N && 0 <= j && j < N) return true;
        return false;
    }
}
