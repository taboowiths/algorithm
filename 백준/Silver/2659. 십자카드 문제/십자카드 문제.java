
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = 4;
        String num = "";
        for (int i = 0; i < N; i++) {
            num += Integer.parseInt(st.nextToken());
        }
        int checkNum = Integer.parseInt(num);
        int minNum = isCircle(checkNum);
        System.out.println(getNumberOfCircle(minNum));
    }

    public static int getNumberOfCircle (int minValue) {
        int cnt = 0;
        for (int i = 1111; i <= minValue; i++) {
            if (isCircle(i) == i) cnt++;
        }
        return cnt;
    }

    public static int isCircle (int checkNum) {
        int temp = checkNum;
        for (int i = 0; i < 3; i++) {
            checkNum = checkNum % 1000 * 10 + checkNum / 1000;
            if (temp > checkNum) temp = checkNum;
        }
        return temp;
    }
}
