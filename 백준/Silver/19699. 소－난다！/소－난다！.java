import java.util.*;
import java.io.*;
public class Main {
    static int N, M, weight[], numbers[];
    static HashSet<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = new int[N];
        numbers = new int[M];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        getCows(0, 0);
        ArrayList<Integer> cows = new ArrayList<>(set);

        Collections.sort(cows);

        if (cows.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < cows.size(); i++) {
                System.out.print(cows.get(i) + " ");
            }
        }
        br.close();
    }

    public static void getCows (int cnt, int start) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < M; i++) {
                sum += numbers[i];
            }
            if (isPrime(sum)){
                set.add(sum);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = weight[i];
            getCows(cnt+1, i+1);
        }
    }

    public static boolean isPrime (int sum) {
        if(sum < 2) return false;
        for (int i = 2; i*i <= sum; i++) {
            if (sum % i == 0) return false;
        }
        return true;
    }
}
