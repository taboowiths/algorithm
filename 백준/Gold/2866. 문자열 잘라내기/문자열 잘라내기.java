import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static String[] rows, cols;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        rows = new String[R];
        cols = new String[C];

        for(int i = 0; i < R; i++) {
            rows[i] = br.readLine();
        }

        StringBuilder sb;
        for (int j = 0; j < C; j++) {
            sb = new StringBuilder();
            for (int i = 1; i < R; i++) {
                sb.append(rows[i].charAt(j));
            }
            cols[j] = sb.toString();
        }


        int cnt = 0;
        int left = 0;
        int right = R-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isDuplicated(mid)) // 중복 없음
                left = mid + 1;
            else {
                cnt = mid;
                right = mid - 1;
            }
        }
        System.out.println(cnt);
    }

    public static boolean isDuplicated (int mid) {
        HashSet<String> set = new HashSet<>();
        for (int j = 0; j < C; j++) {
            String s = cols[j].substring(mid);
            if (!set.contains(s)) set.add(s);
            else return false;
        }
        return true; // 중복 있음 -> false, 중복 없음 -> true
    }
}
