import java.util.*;
import java.io.*;

public class Main{

	static int[] di = {0, 1, 0, -1}; // 우하좌상 
	static int[] dj = {1, 0, -1, 0};
	
	static int N, L, R;
	static boolean flag;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		flag = true;
		while (flag) {
			result++;
			flag = false;
			boolean [][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					bfs(i, j, visited);
				}
			}
		}
		System.out.println(result-1);
        br.close();
	}
	
	static void bfs(int i, int j, boolean[][] visited) {
		int cnt = 1;
		int total = map[i][j];
		Queue<int[]> queue = new LinkedList<int[]>();
		ArrayList<int[]> counts = new ArrayList<int[]>();
		visited[i][j] = true;
		queue.offer(new int[] {i, j});
		counts.add(new int[] {i, j});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			i = cur[0];
			j = cur[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
					if (Math.abs(map[i][j]-map[ni][nj]) >= L && Math.abs(map[i][j]-map[ni][nj]) <= R) {
						visited[ni][nj] = true;
						flag = true;
						queue.offer(new int[] {ni, nj});
						counts.add(new int[] {ni, nj});
						total += map[ni][nj];
						cnt++;
					}
				}
			}
		}
		
		if (counts.size() > 1) {
			for (int k = 0; k < counts.size(); k++) {
				int[] cur = counts.get(k);
				int x = cur[0];
				int y = cur[1];
				map[x][y] = total/cnt;
			}
		}
	}
}
