package bj;
import java.util.*;
import java.io.*;
public class Main_bj_17143_낚시왕{
    static class Shark implements Comparable<Shark> {
        int x, y, speed, dir, size;
        public Shark (int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
        @Override
        public int compareTo(Shark o) {
            return this.size - o.size; // 오름차순. 덮어 씌우도록.
        }
    }
    static int R, C, M, result;
    static int[] di = {-1, 1, 0, 0}; // 상하우좌
    static int[] dj = {0, 0, 1, -1};
    static PriorityQueue<Shark> sharks;
    static Shark map[][];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_17143.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken()); // 격자판 크기
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 상어 수
        map = new Shark[R][C];
        sharks = new PriorityQueue<>();
        result = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            map[x][y] = new Shark(x, y, s, d, z);
        }
        for (int j = 0; j < C; j++) {
            System.out.println("---" + j +"열 이동---");
            searchShark(j);
        }
        System.out.println(result);
    }

    static void searchShark (int j) { // 열 입력 받아서 한 줄 낚시.
        int i = 0;
        while (i < R) {
            if (map[i][j] != null) { // 상어 잡음
                result += map[i][j].size;
                System.out.println("잡은 상어: " + map[i][j].x + " " + map[i][j].y);
                map[i][j] = null;
                break; // 한 마리 잡으면 끝!
            } else i++;
        }
        init(); // 상어 pq에 넣고, 낚시판 초기화.
        moveShark(); // 상어 이동.
    }

    static void moveShark () { // 상어 움직이기
        while (!sharks.isEmpty()) {
            Shark sh = sharks.poll();
            int time = sh.speed;
            if (sh.dir == 0 || sh.dir == 1) {
                time %= (R - 1) * 2;
            } else if (sh.dir == 2 || sh.dir == 3) {
                time %= (C - 1) * 2;
            }
            for (int i = 0; i < time; i++) {
                int ni = sh.x += di[sh.dir];
                int nj = sh.y += dj[sh.dir];
                if (check(ni, nj)) { // 영역 밖으로 나감
                    sh.x -= di[sh.dir]; // 다시 백
                    sh.y -= dj[sh.dir];
                    System.out.println(sh.size + "크기 방향 전환 이전: "+ sh.dir);
                    sh.dir = sh.dir % 2 == 0 ? sh.dir + 1:sh.dir - 1; // 방향 바꾸기
                    System.out.println(sh.size + "크기 방향 전환 이후: " + sh.dir);
                    continue;
                }
                sh.x = ni; sh.y = nj; // 무브 무브
            }
            map[sh.x][sh.y] = sh;
        }
    }

    static void init() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != null) {
                    // 나중에 이거 그냥 map[i][j] 넣으면 안되는지 해보기.
                    sharks.offer(new Shark(i, j, map[i][j].speed, map[i][j].dir, map[i][j].size));
                }
            }
        }
        map = new Shark[R][C]; // 초기화
    }

    static boolean check (int i, int j) {
        return i < 0 || i >= R || j < 0 || j >= C;
    }
}