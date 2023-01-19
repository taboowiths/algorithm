import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] input = new int[10][10];
        int max = Integer.MIN_VALUE;
        int maxX = 0, maxY = 0;
        StringTokenizer st;

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 9; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (input[i][j] > max) {
                    maxX = i;
                    maxY = j;
                    max = input[i][j];
                }
            }
        }

        System.out.println(max);
        System.out.println(maxX + " " + maxY);

        br.close();
    }
}


