import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[6];
        int[] result = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 6; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        result[0] = 1 - input[0];
        result[1] = 1 - input[1];
        result[2] = 2 - input[2];
        result[3] = 2 - input[3];
        result[4] = 2 - input[4];
        result[5] = 8 - input[5];

        for (int i = 0; i < 6; i++) {
            System.out.print(result[i] + " ");
        }
        br.close();
    }
}