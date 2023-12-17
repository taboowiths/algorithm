import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean prime[] = new boolean[1000001];
        prime[0] = prime[1] = true;

        for(int i=2; i*i<=1000000; i++){
            if(!prime[i]){
                for(int j=i*i; j<=1000000; j+=i) prime[j]=true;
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            boolean flag = false;
            for (int i = 1; i <= N; i++) {
                if (!prime[i] && !prime[N-i]) {
                    sb.append(N).append(" = ").append(i).append(" + ").append(N-i).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) sb.append("Goldbach's conjecture is wrong.").append("\n");
        }
        
        System.out.println(sb);
    }
}
