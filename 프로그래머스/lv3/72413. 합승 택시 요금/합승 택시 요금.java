import java.util.*;
class Solution {
    static List<int[]>[] graph;
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new List[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<int[]>();
        for (int i = 0; i < fares.length; i++) {
            graph[fares[i][0]].add(new int[] {fares[i][1], fares[i][2]});
            graph[fares[i][1]].add(new int[] {fares[i][0], fares[i][2]});
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int answer = 0;
            int[] distance = new int[n+1];
            for (int j = 1; j <= n; j++) distance[j] = Integer.MAX_VALUE;
            answer += dijkstra(s, i, n);
            answer += dijkstra(i, a, n);
            answer += dijkstra(i, b, n);
            min = Math.min(min, answer);
        }
        return min;
    }
    
     public static int dijkstra (int from, int to, int n) {
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        for (int j = 1; j <= n; j++) distance[j] = Integer.MAX_VALUE;
        distance[from] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int current = from;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;
            if (current == to) break;

            for(int[] j: graph[current]) {
                if (!visited[j[0]] && distance[j[0]] > distance[current]+j[1]) {
                    distance[j[0]] = distance[current] + j[1];
                }
            }
        }
        return distance[to];
    }
}