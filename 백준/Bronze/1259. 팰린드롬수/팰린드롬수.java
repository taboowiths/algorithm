import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while (!Objects.equals(str = br.readLine(), "0")) {
            if (checkPalin(str)) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    public static boolean checkPalin (String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}


