
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N+1];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = 1;
        int length = 0;

        while (left <= N && right <= N) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            
            while (map.size() > 2) {
                int count = map.get(fruits[left]);
                if (count > 1) {
                    map.put(fruits[left], count - 1);
                } else {
                    map.remove(fruits[left]);
                }
                left++;
            }
            length = Math.max(length, right - left + 1);
            right++;
        }
        System.out.println(length);
    }
}
