import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];
//        String[] check = new String[M];
        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }

//        for (int i = 0; i < M; i++) {
//            check[i] = br.readLine();
//        }

        Arrays.sort(S);
//        Arrays.sort(check);
//        System.out.println(Arrays.toString(S));
        int start, end;
        int cnt = 0;

        for (int i = 0; i < M; i++) {
//            String word = check[i];
            String word = br.readLine();
            start = 0;
            end = S.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (word.compareTo(S[mid]) < 0) {
                    end = mid - 1;
                } else if (word.compareTo(S[mid]) > 0) {
                    start = mid + 1;
                }
//                System.out.println(mid);
                if (S[mid].startsWith(word)) {
//                    System.out.println("loop: " + i);
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
