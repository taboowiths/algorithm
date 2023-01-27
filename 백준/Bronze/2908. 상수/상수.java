import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer N = new StringBuffer(st.nextToken()).reverse();
        StringBuffer M = new StringBuffer(st.nextToken()).reverse();

        if (Integer.parseInt(N.toString()) > Integer.parseInt(M.toString())) {
            System.out.println(N.toString());
        } else {
            System.out.println(M.toString());
        }
        br.close();
    }
}