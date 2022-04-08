package study;

import java.util.*;
import java.io.*;
public class Main_bj_17135_캐슬디펜스 {

    static class Enemy implements Comparable<Enemy>{
        int x, y, dist;
        public Enemy (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Enemy o) {
            if (this.dist == o.dist) return this.y - o.y;
            return this.dist - o.dist;
        }
    }
    static int N, M, D, max, result, map[][], numbers[];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_17135.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        map = new int[N+2][M+2];
        numbers = new int[3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pickCastle(0, 1);
        System.out.println(max);
    }

    static void pickCastle (int cnt, int start) {
        if (cnt == 3) {
            killEnemy();
            max = Math.max(max, result);
            return;
        }

        for (int i = start; i <= M; i++) {
            numbers[cnt] = i;
            pickCastle(cnt+1, i+1);
        }
    }

    static void killEnemy () {
        // 궁수 조합 하나 들어왔을 때.
        result = 0;
        boolean[][] visited = new boolean[N+1][M+1];
        Stack<int[]> st = new Stack<>();
        for (int i = N+1; i > 1 ; i--) { // N+1 번째에 궁수 있음.
            for (int j = 0; j < 3; j++) { // 궁수 한 명씩 반복
                if (gostop(i)) return;
                PriorityQueue<Enemy> pq = new PriorityQueue<>();
                int arc = numbers[j];
                //System.out.println("궁수 위치: " + i + " " + arc);

                for (int x = 1; x < i; x++) {
                    for (int y = 1; y <= M; y++) {
                        if (map[x][y] != 1 || getDistance(i, arc, x, y) > D || visited[x][y]) continue;
                        pq.offer(new Enemy(x, y, getDistance(i, arc, x, y)));
                    }
                }

                if (!pq.isEmpty()) {
                    Enemy cur = pq.poll();
                    //System.out.println("공격할 놈: " + cur.x + " " + cur.y + " " + cur.dist);
                    result++;
                    st.push(new int[] {cur.x, cur.y});
                }
            }
            while (!st.empty()) {
                int[] cur = st.pop();
                if (!visited[cur[0]][cur[1]]) visited[cur[0]][cur[1]] = true;
                else result--;
            }
        }
    }

    static boolean gostop (int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }

    static int getDistance (int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
