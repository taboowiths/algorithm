import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int it = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            sum += it * price;
        }

        if (sum == X) System.out.println("Yes");
        else System.out.println("No");
       
        br.close();

    }
}