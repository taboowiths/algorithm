import java.util.*;
import java.io.*;
public class Main {
    static HashMap<Character, Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        set = new HashMap<>();
        boolean[] charset = new boolean[26];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (!set.containsKey(Character.toUpperCase(s.charAt(0)))) {
                set.put(Character.toUpperCase(s.charAt(0)), 0);
            }

            else if (!checkSpace(s)) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != ' ' && !set.containsKey(Character.toUpperCase(s.charAt(j)))) {
                        set.put(Character.toUpperCase(s.charAt(j)), j);
                        break;
                    }
                }
            }

            for (int j = 0; j < s.length(); j++) {
                char ch = Character.toUpperCase(s.charAt(j));
                if (set.containsKey(ch) && j == set.get(ch) && ch != ' ' && !charset[ch-65]) {
                    System.out.print("[" + s.charAt(j) + "]");
                    charset[ch-65] = true;
                } else {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
    public static boolean checkSpace (String s) {
        if (s.contains(" ")) {
            int idx = 0;
            while (idx < s.length()-1) {
                idx++;
                if (s.charAt(idx) == ' ') {
                    if (!set.containsKey(Character.toUpperCase(s.charAt(idx + 1)))) {
                        set.put(Character.toUpperCase(s.charAt(idx + 1)), idx + 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}