
import java.io.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 52462
 */
public class Main {
    static int[] parents, rank;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        rank = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (X == 0) union(A, B);
            else {
                if (find(A) == find(B)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb.toString());
        br.close();
    }

    public static void union (int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return;
        // rank 가 높은 쪽, 즉 트리의 길이가 긴 쪽에 붙는게 유리하다.
        if (rank[aRoot] < rank[bRoot]) {
            parents[aRoot] = bRoot;
        } else if (rank[aRoot] > rank[bRoot]) {
            parents[bRoot] = aRoot;
        } else { // 같은 경우
            parents[bRoot] = aRoot;
            rank[aRoot]++; // A가 루트인 트리에 B가 루트인 트리가 붙으므로
        }
    }

    public static int find (int a) {
        if (parents[a] == a) return a;
        else {
            parents[a] = find(parents[a]);
            return find(parents[a]);
        }
    }
}
