import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String S = br.readLine();
        int[][] arr = new int[S.length()][26];
        arr[0][S.charAt(0)-'a']++;
        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i-1][j];
            }
            arr[i][S.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine(), " ");
            char alpha = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == 0) sb.append(arr[end][alpha-'a']).append("\n");
            else sb.append(arr[end][alpha-'a'] - arr[start-1][alpha-'a']).append("\n");
        }
        System.out.println(sb.toString());
    }
}