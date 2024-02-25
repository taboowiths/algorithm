import java.io.*;
import java.util.*;
public class Main {
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int answer = -1;
        for (int m = 1; m <= M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (find(from) == find(to)) {
                answer = m;
                break;
            }
            union(from, to);
        }
        if (answer == -1) System.out.println(0);
        else System.out.println(answer);
    }

    public static int find (int a) {
        if (a == parents[a]) return a;
        else return parents[a] = find(parents[a]);
    }

    public static void union (int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parents[bRoot] = aRoot;
    }
}
