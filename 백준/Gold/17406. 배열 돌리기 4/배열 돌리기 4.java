import java.util.*;
import java.io.*;
public class Main {
    static int N, M, K, min, test[][], number[];
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        test = new int[K][3];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            test[k][0] = Integer.parseInt(st.nextToken());
            test[k][1] = Integer.parseInt(st.nextToken());
            test[k][2] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(r + " " + c);
        visited = new boolean[K];
        number = new int[K];
        min = Integer.MAX_VALUE;
        comb(0, map);
        System.out.println(min);
    }

    public static void comb (int cnt, int[][] map) {
        if (cnt == K) {
            int[][] copyMap = copyMap(map);
//            System.out.println(Arrays.toString(number));
            for (int k = 0; k < K; k++) {
                turn(copyMap, number[k]);
            }
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= M; j++) {
                    sum+=copyMap[i][j];
                }
                min = Math.min(min, sum);
            }
            return;
        }
        for (int i = 0; i < K; i++) {
            if (visited[i]) continue;
            number[cnt]=i;
            visited[i]=true;
            comb(cnt+1, map);
            visited[i]=false;
        }
    }

    public static void turn (int[][] map, int t) {
        int R = (test[t][0]+test[t][2]) - (test[t][0]-test[t][2]) + 1;
        int C = (test[t][1]+test[t][2]) - (test[t][1]-test[t][2]) + 1;
        int[] start = new int[] {(test[t][0]-test[t][2]),(test[t][1]-test[t][2])};
//        System.out.println(R + " " + C);
//        System.out.println(Arrays.toString(start));
        int rect = Math.min(R, C)/2;
//        System.out.println(rect);


        for (int l = 0; l < rect; l++) {
            int r = start[0]+l;
            int c = start[1]+l;
//            System.out.println("시작점:" + r + " " + c);
            int max_r = R+start[0]-1-l;
            int max_c = C+start[1]-1-l;
//            System.out.println(max_r + " " + max_c);
            int tmp = map[max_r][c];
//            System.out.println(tmp);
            for (int i = c; i < max_c; i++) {
                map[max_r][i] = map[max_r][i+1];
            }
            for (int i = max_r; i > r; i--) {
                map[i][max_c] = map[i-1][max_c];
            }
            for (int i = max_c; i > c; i--) {
                map[r][i] = map[r][i-1];
            }
            for (int i = r; i < max_r; i++) {
                map[i][c] = map[i+1][c];
            }

            map[max_r-1][c] = tmp;
        }
    }

    public static int[][] copyMap(int[][] map) {
        int[][] copyMap = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }
}
