import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            if (num > 0) right.add(num);
            else left.add(num);
        }
        Collections.sort(left);
        Collections.sort(right);

        boolean side = false;
        if (left.size() > 1 && right.size() > 1) {
            side = Math.abs(left.get(0)) > right.get(right.size()-1);
        } else {
            if (left.size() > 1) side = true;
        }

        int result = 0;
        if (side) { // 왼쪽이 큼 -> 왼쪽에서 끝남 -> 오른쪽부터 다녀오기
            for (int i = right.size()-1; i >= 0; i-=M) {
                result += (right.get(i)*2);
            }
            for (int i = 0; i < left.size(); i+=M) {
                result += (Math.abs(left.get(i))*2);
            }
            result -= Math.abs(left.get(0));
        } else {
            for (int i = 0; i < left.size(); i+=M) {
                result += (Math.abs(left.get(i))*2);
            }
            for (int i = right.size()-1; i >= 0; i-=M) {
                result += (right.get(i)*2);
            }
            result -= right.get(right.size()-1);
        }
        System.out.println(result);
    }
}
