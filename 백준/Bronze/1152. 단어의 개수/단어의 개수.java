import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer st = new StringTokenizer(s = br.readLine(), " ");
        int cnt = 0;

        while (st.hasMoreTokens()) {
            s = st.nextToken();
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}