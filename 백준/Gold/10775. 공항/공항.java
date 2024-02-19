import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parents = new int[G+1];
        for (int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int plane = Integer.parseInt(br.readLine());
            int gate = find(plane);
            if (gate == 0) break;
            cnt++;
            union(gate, gate-1);
        }
        System.out.println(cnt);
    }

    public static void union (int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) parents[aRoot] = bRoot;
    }

    public static int find (int p) {
        if (p == parents[p]) return p;
        return parents[p] = find(parents[p]);
    }
}
