import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        Arrays.sort(arr);
        int zero = 0;
        int one = 0;
        for (String s : arr) {
            if (s.equals("0")) zero++;
            else one++;
        }

        int idx = 0;
        for (int i = 0; i < zero/2; i++) {
            arr[idx++] = "-1";
        }
        idx = arr.length-1;
        for (int i = 0; i < one/2; i++) {
            arr[idx--] = "-1";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (!s.equals("-1")) sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
