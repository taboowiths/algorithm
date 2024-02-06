import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = 20;
        double cnt = 0.0;
        double result = 0.0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String title = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String score = st.nextToken();
            if (!score.equals("P")) {
                result += getScore(credit, score);
                cnt += credit;
            }
        }
        if (cnt == 0.0) System.out.println(0.0);
        else System.out.println(result / cnt);
    }

    public static double getScore (double credit, String score) {
        if (score.equals("A+")) return credit * 4.5;
        else if (score.equals("A0")) return credit * 4.0;
        else if (score.equals("B+")) return credit * 3.5;
        else if (score.equals("B0")) return credit * 3.0;
        else if (score.equals("C+")) return credit * 2.5;
        else if (score.equals("C0")) return credit * 2.0;
        else if (score.equals("D+")) return credit * 1.5;
        else if (score.equals("D0")) return credit;
        else return 0.0;
    }
}