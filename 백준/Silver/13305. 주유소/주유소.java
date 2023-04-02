import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long [] distance = new Long[N];
        Long[] price = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        Long cur = price[0];
        Long total = cur * distance[1];
        for (int i = 1; i < N-1; i++) {
            if (price[i] <= cur) {
                cur = price[i];
            }
            total += cur * distance[i+1];
        }
        System.out.println(total);
        br.close();
    }
}
