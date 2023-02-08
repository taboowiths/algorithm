import java.io.*;
import java.util.*;

public class Main{

	static int[] di = {-1, 0, 1, 0}; // 상우하좌
	static int[] dj = {0, 1, 0, -1}; 
	static int N, M, nodes;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			nodes = 0;
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for (int i = 0; i < cnt; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
            
            for (int i = 0; i < M; i++) {
			    for (int j = 0; j < N; j++) {
				    if (!visited[i][j] && map[i][j] == 1) {
					    nodes++;
					    bfs(i, j);
				    }
			    }
		    }
		    System.out.println(nodes);
		}
        br.close();
	}
	
	static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			i = cur[0];
			j = cur[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < M && 0 <= nj && nj < N && !visited[ni][nj] && map[ni][nj] == 1) {
					visited[ni][nj] = true;
					bfs(ni, nj);
				}
			}
		}
		
	}

}
