import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("END")) break;
            for (int i = s.length()-1; i >= 0; i--) {
                res.append(s.charAt(i));
            }
            res.append("\n");
        }
        System.out.println(res.toString());
        br.close();
    }
}
