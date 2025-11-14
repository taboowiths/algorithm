import java.util.*;
import java.io.*;

class Main {
    static int[] trees;
    static int N, M;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        int maxHeight = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }


        // 1. h의 범위: 1 ~ 최대 높이 maxHeight
        int start = 1;
        int end = maxHeight;
        int targetHeight = 0; // 찾아야 하는 높이 (M보다 같거나 큰 최대 수)

        while (start <= end) {
            int mid = (start + end) / 2;
            long pieces = getPieces(mid);
            if (pieces >= M) {
                targetHeight = mid;
                start = mid + 1;
            } else if (pieces < M) {
                end = mid - 1;
            } else if (pieces == M) {
                break;
            }
        }
        System.out.println(targetHeight);
    }

    public static long getPieces(int height) {
        long pieces = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > height) pieces += (trees[i] - height);
        }
        return pieces;
    }
}