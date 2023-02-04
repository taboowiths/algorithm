import java.util.*;
import java.io.*;
public class Main {
    static int N, min, map[][], input[];
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        input = new int[N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i] = i;
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
        br.close();
    }

    public static void comb (int cnt, int start) {
        if (cnt > N/2) {
            return;
        }
        if (cnt > 0) {
            makeTeam();
        }
        for (int i = start; i < N; i++) {
            visited[input[i]] = true;
            comb(cnt+1, i+1);
            visited[input[i]] = false;
        }
    }

    public static void makeTeam() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] && visited[j]) start += map[i][j] + map[j][i];
                else if (!visited[i] && !visited[j]) link += map[i][j] + map[j][i];
            }
        }

        int diff = Math.abs(start - link);
        min = Math.min(diff, min);
    }
}
