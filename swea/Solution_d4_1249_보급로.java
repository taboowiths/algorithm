package SWEA;
import java.util.*;
import java.io.*;
public class Solution_d4_1249_보급로 {

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
    static boolean visited[][];
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_d4_1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j)-'0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[0][0] = 0;
            pq.offer(new Node(0, 0, dist[0][0]));
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
            System.out.println("#"+tc+" "+dist[N-1][N-1]);
        }
    }
    static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}
