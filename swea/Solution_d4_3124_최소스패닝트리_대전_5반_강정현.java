package SWEA;
import java.io.*;
import java.util.*;
public class Solution_d4_3124_최소스패닝트리_대전_5반_강정현 {


    static int[] parents;
    static int[][] edgeList;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_d4_3124.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken()); // 정점의 개수
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수
            edgeList = new int[E][3];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new int[] {from, to, weight};
            }

            Arrays.sort(edgeList, (o1,o2)->Integer.compare(o1[2],o2[2])); // 간선비용의 오름차순정렬
            makeSet(V);

            int result = 0;
            int cnt = 0;
            for(int[] edge : edgeList){
                if(union(edge[0],edge[1])){
                    result += edge[2];
                    if(++cnt == V-1) break;
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    public static void makeSet(int V){
        parents = new int[V+1];
        for(int i = 0; i < V; i++){
            parents[i] = i;
        }
    }

    public static int findSet(int a){
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}