import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Acnt = new int[N+1];
        int[] Bcnt = new int[N+1];
        Acnt[0] = 1; Acnt[1] = 0;
        Bcnt[0] = 0; Bcnt[1] = 1;

        for (int i = 2; i <= N; i++) {
            Acnt[i] = Acnt[i-1] + Acnt[i-2];
            Bcnt[i] = Bcnt[i-1] + Bcnt[i-2];
        }

        System.out.println(Acnt[N] + " " + Bcnt[N]);
    }
}
