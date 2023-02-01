import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] counting = new int[10000000];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            counting[input[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        for (int i = N-1; i >= 0; i--) {
            int value = input[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb.toString());
        br.close();
    }
}
