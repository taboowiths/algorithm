import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> stones = new ArrayList<>();

        for (int i = 0; i < n; i++) stones.add(Integer.parseInt(br.readLine()));
        stones.add(d);
        Collections.sort(stones);
//        System.out.println(stones);
        int left = 0;
        int right = d;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right)/2;
//            System.out.println("left: " + left + ", right: " + right + ", mid: " + mid);
            int pre = 0;
            int cnt = 0;
            for (int stone : stones) {
                if (stone - pre < mid) {
//                    System.out.println("stone: " + stone);
                    cnt++;
                }
                else pre = stone;
            }
//            System.out.println("cnt: " + cnt);
            if (cnt > m) right = mid - 1; // 건널 수 있는 다리의 개수가 많으면, mid 값을 줄인다.
            else {
                ans = mid;
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
