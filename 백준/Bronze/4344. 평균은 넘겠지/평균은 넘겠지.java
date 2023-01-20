import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            double sum = 0;
            double students = 0;
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                sum += scores[i];
            }
            double avg = sum / N;
            for (int i = 0; i < N; i++) {
                if (scores[i] > avg) students++;
            }
            sb.append(String.format("%.3f", students/N*100)).append("%").append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}


