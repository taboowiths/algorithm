import java.io.*;

public class Main {
    static int N;
    static int[] P;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        if (N == 1) sb.append(1);
        else {
            for (int i = 1; i <= N; i++) {
                if (i == 0) {
                    if (P[i] >= P[i+1]) sb.append(i).append("\n");
                } else if (i == N) {
                    if (P[i] >= P[i-1]) sb.append(i).append("\n");
                } else {
                    if (P[i] >= P[i+1] && P[i] >= P[i-1]) sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
