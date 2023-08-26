import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[] strs = new String[R];
        String[] cols = new String[C];

        for(int i = 0; i < R; i++) {
            strs[i] = br.readLine();
        }

        for (int j = 0; j < C; j++) {
            String s = "";
            for (int i = 1; i < R; i++) {
                s += strs[i].charAt(j);
            }
            cols[j] = s;
        }

        HashSet<String> set;
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            set = new HashSet<>();
            for (int j = 0; j < C; j++) {
                String str = cols[j].substring(i);
                set.add(str);
            }
            if (set.size() != C) break;
            cnt++;
        }
        System.out.println(cnt);
    }
}
