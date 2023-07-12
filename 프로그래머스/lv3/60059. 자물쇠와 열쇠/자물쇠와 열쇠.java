class Solution {
    static int N, M, hole;
    public static boolean solution (int[][] key, int[][] lock) {
        boolean answer = false;
        N = lock.length;
        M = key.length;

        hole = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) hole++;
            }
        }

        int K = N+2*M;
        int[][] newLock = new int[K][K];
        for (int i = M; i < M+N; i++) {
            for (int j = M; j < M+N; j++) {
                newLock[i][j] = lock[i-M][j-M];
            }
        }

        done: for (int cnt = 0; cnt < 4; cnt++) {
                for (int i = 1; i < K-M; i++) {
                    for (int j = 1; j < K-M; j++) {
                        if (isAvail(key, newLock, i, j)){
                            answer = true;
                            break done;
                        }
                    }
                }
            key = turnKey(key);
        }
        return answer;
    }
    
    public static boolean isAvail (int[][] key, int[][] lock, int start_x, int start_y) {
        int key_x = 0;
        int key_y = 0;
        int holeCnt = 0; // 채운 구멍 수
        for (int i = start_x; i < start_x + M; i++) {
            for (int j = start_y; j < start_y + M; j++) {
                if (M <= i && i < N+M && M <= j && j < N+M) { // 자물쇠 범위 내
                    if (key[key_x][key_y] == 1 && lock[i][j] == 1) return false;
                    if (key[key_x][key_y] == 1 && lock[i][j] == 0) holeCnt++;
                }
                key_y++;
            }
            key_x++;
            key_y = 0;
        }
        return hole == holeCnt;
    }

    public static int[][] turnKey (int[][] key) {
        int[][] newKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                newKey[i][j] = key[M-j-1][i];
            }
        }
        return newKey;
    }
}