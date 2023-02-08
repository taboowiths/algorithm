import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int[] students = new int[N];

        int num = 1;
        for (int i = 0; i < N; i++) {
            while (String.valueOf(num).contains(L)) {
                num++;
            }
            students[i] = num;
            num++;
        }
        System.out.println(students[N-1]);
    }
}
