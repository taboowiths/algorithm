import java.util.*;
import java.io.*;
public class Main {
    static int N, time, size, eat, map[][], check[][], di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1};
    static Shark baby;
    public static class Shark implements Comparable<Shark> {
        int x, y, dist;
        public Shark (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    if (this.y > o.y) return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    baby = new Shark(i, j, 0);
                    queue.offer(new int[] {baby.x, baby.y});
                    map[i][j] = 0;
                }
            }
        }
        eat = 0;
        size = 2;
        time = 0;

        while (true) {
            check = new int[N][N];
            check[baby.x][baby.y] = 0;
            PriorityQueue<Shark> pq = new PriorityQueue<>();
            if (!bfs(queue, pq)) break;
        }
        System.out.println(time);
    }

    public static boolean bfs (Queue<int[]> queue, PriorityQueue<Shark> pq) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (!check(ni, nj) || check[ni][nj] != 0 || map[ni][nj] > size) continue;
                check[ni][nj] = check[i][j] + 1; // 이동시간 표기
                queue.offer(new int[]{ni, nj});
                if (map[ni][nj] != 0 && map[ni][nj] < size) {
                    pq.offer(new Shark(ni, nj, check[ni][nj]));
                }
            }
        }

        if (pq.isEmpty()) {
            return false;
        }

        Shark edible = pq.poll();
        time += edible.dist;
        eat++;
        map[edible.x][edible.y] = 0;
        if (eat == size) {
            size++;
            eat = 0;
        }
        queue.offer(new int[] {edible.x, edible.y});
        return true;
    }


    public static boolean check (int i, int j) {
        return 0 <= i && i < N && 0 <= j && j < N;
    }
}
