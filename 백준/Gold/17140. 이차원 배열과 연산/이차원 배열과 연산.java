import java.util.*;
import java.io.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int num, cnt;
        public Node (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt == o.cnt) return this.num - o.num;
             else return this.cnt - o.cnt;
        }
    }

    static int map[][], row=3, col=3, r, c, k, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " " );
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[101][101];
        ans = -1;

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getCompute();
        System.out.println(ans);
        br.close();
    }

    public static void getCompute () {
        int time = 0;
        while (time <= 100) {
            if (map[r][c] == k) {
                ans = time;
                break;
            } else {
                if (row >= col) R();
                else C();
                time++;
            }
        }
    }

    public static void C() {
        int maxRow = 0;
        for (int i = 1; i <= col; i++) {
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int j = 1; j <= row; j++) {
                if (map[j][i] == 0) continue;
                else if (hashmap.containsKey(map[j][i])) {
                    hashmap.put(map[j][i], hashmap.get(map[j][i])+1);
                } else {
                    hashmap.put(map[j][i], 1);
                }
            }
            for (Integer k: hashmap.keySet()) {
                pq.offer(new Node(k, hashmap.get(k)));
            }

            int tmp = 1;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                map[tmp++][i] = cur.num;
                map[tmp++][i] = cur.cnt;
            }

            maxRow = Math.max(maxRow, tmp);

            while (tmp <= 100) {
                map[tmp++][i] = 0;
            }
        }
        row = maxRow-1;
    }

    public static void R() {
        int maxCol = 0;
        for (int i = 1; i <= row; i++) {
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int j = 1; j <= col; j++) {
                if (map[i][j] == 0) continue;
                else if (hashmap.containsKey(map[i][j])) {
                    hashmap.put(map[i][j], hashmap.get(map[i][j])+1);
                } else {
                    hashmap.put(map[i][j], 1);
                }
            }
            for (Integer k: hashmap.keySet()) {
                pq.offer(new Node(k, hashmap.get(k)));
            }

            int tmp = 1;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                map[i][tmp++] = cur.num;
                map[i][tmp++] = cur.cnt;
            }

            maxCol = Math.max(maxCol, tmp);
            while (tmp <= 100) {
                map[i][tmp++] = 0;
            }
        }
        col = maxCol-1;
    }
}
