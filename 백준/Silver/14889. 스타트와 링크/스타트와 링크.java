import java.io.*;
import java.util.*;

public class Main{

	static int N, min;
	static int[] input;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		input = new int[N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			input[i] = i; // 인덱스 부여 
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(min);
		br.close();
	}

	static void comb(int cnt, int start){
		if (cnt == N/2) {
			team();
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[input[i]] = true;
			comb(cnt + 1, i + 1);
			visited[input[i]] = false;
		}
	}
	
	static void team() {
		int t1 = 0;
		int t2 = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (visited[i] & visited[j]) {
					t1 += map[i][j] + map[j][i];
				}
				else if (!visited[i] & !visited[j]) {
					t2 += map[i][j] + map[j][i];
				}
			}
		}
		min = Math.min(min, Math.abs(t1-t2));
	}
}
