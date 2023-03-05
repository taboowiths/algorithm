import java.util.*;
import java.io.*;
public class Main {
    static int R, C, di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1}, visited[][];
    static char map[][];
    public static class Node {
        int x, y;
        char it;
        public Node (int x, int y, char it) {
            this.x = x;
            this.y = y;
            this.it = it;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        int caveX = 0, caveY = 0;
        Queue<Node> queue = new ArrayDeque<>();
        int[][] visited = new int[R][C];
        Node gosm = null;
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    gosm = new Node(i, j, 'S');
                } else if (map[i][j] == 'D') {
                    caveX = i;
                    caveY = j;
                } else if (map[i][j] == '*') {
                    queue.offer(new Node(i, j, '*'));
                }
            }
        }
        visited[gosm.x][gosm.y] = 1;
        queue.offer(gosm);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == caveX && cur.y == caveY) break;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + di[d];
                int ny = cur.y + dj[d];
                if (!check(nx, ny)) continue;
                if (cur.it == '*') {
                    if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
                        map[nx][ny] = '*';
                        queue.offer(new Node(nx, ny, '*'));
                    }
                } else if (cur.it == 'S') {
                    if (map[nx][ny] == '.' || map[nx][ny] == 'D') {
                        if (visited[nx][ny] == 0) {
                            visited[nx][ny] = visited[cur.x][cur.y] + 1;
                            queue.offer(new Node (nx, ny, 'S'));
                        }
                    }
                }
            }
        }

        if (visited[caveX][caveY] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(visited[caveX][caveY]-1);
        }
        br.close();
    }
    
    public static boolean check (int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }
}
