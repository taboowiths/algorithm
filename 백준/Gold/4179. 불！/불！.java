import java.util.*;
import java.io.*;
public class Main {
    public static class Node {
        int x, y;
        char it;

        public Node (int x, int y, char it) {
            this.x = x;
            this.y = y;
            this.it = it;
        }
    }
    static int jx, jy, exitX, exitY, R, C, di[]={-1, 1, 0, 0}, dj[]={0, 0, -1, 1};
    static char map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'F') {
                    queue.offer(new Node(i, j, 'F'));
                }
                else if (map[i][j] == 'J') {
                    jx = i;
                    jy = j;
                }
            }
        }
        int[][] visited = new int[R][C];
        queue.offer(new Node (jx, jy, 'J'));
        visited[jx][jy] = 1;
        bfs(queue, visited);

//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        if (visited[exitX][exitY] == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(visited[exitX][exitY]);
    }

    public static void bfs (Queue<Node> queue, int[][] visited) {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.it == 'J' && isEscapable(cur.x, cur.y)) {
//                System.out.println("방문 값: " + visited[cur.x][cur.y]);
//                System.out.println(cur.x + " " + cur.y);
                exitX = cur.x; exitY = cur.y;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int ni = cur.x + di[d];
                int nj = cur.y + dj[d];
                if (!check(ni, nj)) continue;
                if (cur.it == 'F') {
                    if (map[ni][nj] == '.' || map[ni][nj] == 'J') {
                        map[ni][nj] = 'F';
                        queue.offer(new Node (ni, nj, 'F'));
                    }
                } else if (cur.it == 'J') {
                    if (map[ni][nj] == '.') {
                        if (visited[ni][nj] == 0) {
                            visited[ni][nj] = visited[cur.x][cur.y] + 1;
                            queue.offer(new Node (ni, nj, 'J'));
                        }
                    }
                }
            }

        }
    }

    public static boolean isEscapable (int i, int j) {
//        if (map[i][j] == '.') {
//            System.out.println(i + " " + j);
//            return i == 0 || j == 0 || i == R-1 || j == C-1;
//        }
//        return false;
        return i == 0 || j == 0 || i == R-1 || j == C-1;
    }

    public static boolean check(int i, int j) {
        return 0 <= i && i < R && 0 <= j && j < C;
    }
}
