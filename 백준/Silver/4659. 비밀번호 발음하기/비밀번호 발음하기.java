import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        StringBuilder sb = new StringBuilder();
        while (true) {
            s = br.readLine();
            if (s.equals("end")) break;
            String[] str = new String[s.length()];
            for (int i = 0; i < str.length; i++) {
                str[i] = String.valueOf(s.charAt(i));
            }

            String vow = "aeiou";
            boolean flag = true;
            int v = 0;
            int c = 0;
            int v_repeat = 0;
            int c_repeat = 0;
            for (int i = 0; i < str.length; i++) {
                if (vow.contains(str[i])) {
                    c_repeat = 0;
                    v++;
                    v_repeat++;
                    if (v_repeat >= 3) {
                        flag = false;
                        break;
                    }
                    if (i > 0 && str[i].equals(str[i-1])) {
                        String tmp = str[i-1]+str[i];
                        if (!tmp.equals("ee") && !(tmp).equals("oo")) {
                            flag = false;
                            break;
                        }
                    }
                } else {
                    v_repeat = 0;
                    c++;
                    c_repeat++;
                    if (c_repeat >= 3) {
                        flag = false;
                        break;
                    }
                    if (i > 0 && str[i].equals(str[i-1])) {
                        flag = false;
                        break;
                    }
                }
            }
            if (v < 1 || !flag) sb.append("<").append(s).append(">").append(" is not acceptable.").append("\n");
            else sb.append("<").append(s).append(">").append(" is acceptable.").append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
