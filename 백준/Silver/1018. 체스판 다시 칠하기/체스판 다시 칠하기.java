import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int min = 987654321;
        char[][] copyMap = new char[N][M];
        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(map[i], 0, copyMap[i], 0, M);
        }
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                int result = changeColor(i, j, copyMap);
                min = Math.min(result, min);
            }
        }
        System.out.println(min);
    }

    public static int changeColor (int startX, int startY, char[][] map) {
        // 맨 상단 왼쪽을 화이트로 시작하는 경우
        int white = 0;
        if (map[startX][startY] == 'B') { // 맨 상단 왼쪽이 블랙인 경우
            white++; // 변경 횟수
            map[startX][startY] = 'W'; // 화이트로 변경
        }

        for (int i = startX; i < startX+8; i++) {
            for (int j = startY; j < startY+8; j++) {
                if (i == startX && j == startY) continue;
                if (i == startX) { // 최상단 -> 왼쪽 확인
                    if (map[i][j-1] == 'W' && map[i][j] == 'W') {
                        white++;
                        map[i][j] = 'B';
                    } else if (map[i][j-1] == 'B' && map[i][j] == 'B') {
                        white++;
                        map[i][j] = 'W';
                    }
                } else { // 그 외 -> 위쪽 확인
                    if (map[i-1][j] == 'W' && map[i][j] == 'W') {
                        white++;
                        map[i][j] = 'B';
                    } else if (map[i-1][j] == 'B' && map[i][j] == 'B') {
                        white++;
                        map[i][j] = 'W';
                    }
                }
            }
        }

        resetMap(startX, startY, map);

        // 맨 상단 왼쪽을 블랙으로 시작하는 경우
        int black = 0;
        if (map[startX][startY] == 'W') { // 맨 상단 왼쪽이 화이트인 경우
            black++; // 변경 횟수
            map[startX][startY] = 'B'; // 블랙으로 변경
        }

        for (int i = startX; i < startX+8; i++) {
            for (int j = startY; j < startY+8; j++) {
                if (i == startX && j == startY) continue;
                if (i == startX) { // 최상단 -> 왼쪽 확인
                    if (map[i][j-1] == 'W' && map[i][j] == 'W') {
                        black++;
                        map[i][j] = 'B';
                    } else if (map[i][j-1] == 'B' && map[i][j] == 'B') {
                        black++;
                        map[i][j] = 'W';
                    }
                } else { // 그 외 -> 위쪽 확인
                    if (map[i-1][j] == 'W' && map[i][j] == 'W') {
                        black++;
                        map[i][j] = 'B';
                    } else if (map[i-1][j] == 'B' && map[i][j] == 'B') {
                        black++;
                        map[i][j] = 'W';
                    }
                }
            }
        }
        resetMap(startX, startY, map);
        return Math.min(black, white);

    }

    public static void resetMap (int startX, int startY, char[][] copyMap) {
        for (int i = startX; i < startX+8; i++) {
            for (int j = startY; j < startY+8; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }
}
