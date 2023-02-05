import java.util.*;
import java.io.*;
public class Main {
    public static class Shark implements Comparable<Shark> {
        int r, c, s, d, z;
        public Shark (int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
        @Override
        public int compareTo(Shark o) {
            return this.z - o.z;
        }
    }
    static int R, C, M, result, di[]={-1, 1, 0, 0}, dj[]={0, 0, 1, -1};
    static Shark map[][];
    static PriorityQueue<Shark> sharks;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R+1][C+1];
        sharks = new PriorityQueue<>();
        result = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, s, d, z);
        }
        for (int i = 0; i < C; i++) {
            searchShark(i);
//            System.out.println("======================");
        }
        System.out.println(result);
    }
    
    public static void searchShark (int j) {
        int i = 0;
        while (i < R) {
            if (map[i][j] != null) {
//                System.out.println(j + ": " + +map[i][j].z);
                result += map[i][j].z;
                map[i][j] = null;
                break;
            } else i++;
        }
        init();
        moveShark();
    }

    public static void moveShark() {
        while (!sharks.isEmpty()) {
            Shark shark = sharks.poll();
            int time = shark.s;
            if (shark.d == 0 || shark.d == 1) { // 상하
                time %= (R-1)*2;
            } else if (shark.d == 2 || shark.d == 3) { // 우좌
                time %= (C-1)*2;
            }
            for (int i = 0; i < time; i++) {
                int ni = shark.r += di[shark.d];
                int nj = shark.c += dj[shark.d];
                if (!check(ni, nj)) { // 범위 밖 -> 방향 바꿔줌
                    ni -= di[shark.d];
                    nj -= dj[shark.d];
                    shark.d = shark.d % 2 == 0 ? shark.d+1 : shark.d-1;
                    ni += di[shark.d];
                    nj += dj[shark.d];
                }
                shark.r = ni; shark.c = nj;
//                System.out.println("이동 중: " + shark.r + " " + shark.c + " " + shark.z);
            }
//            System.out.println("이동 후 위치: " + shark.r + " " + shark.c + " " + shark.z);
            map[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
        }
    }

    public static void init () {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j]!=null) {
                    sharks.offer(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
                }
            }
        }
        map = new Shark[R][C];
    }

    public static boolean check(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }
}
