import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[] bottles = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bottles[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(bottles); // 정렬

        int start = 0;
        int end = N - 1;
        int entire = 0; // 꽉 찬 에센스 한 병의 개수 
        int remain = 0;

        // 1. 뒤에서부터 꽉 찬 병 제거
        while (end >= 0 && bottles[end] == X) {
            entire++;
            end--;
        }
        // 2. X/2 이상 만들 수 있는 쌍 찾기
        while (start <= end) {
            if (start == end) {
                remain++;
                break;
            }

            if ((bottles[start] + bottles[end]) * 2 >= X) { // 절반 양보다 큼 -> 꽉 찬 에센스 받을 수 있음.
                entire++;
                start++;
                end--;
            } else {
                remain++;
                start++;
            }
        }

        System.out.println(entire + (remain / 3));

        br.close();
    }
}