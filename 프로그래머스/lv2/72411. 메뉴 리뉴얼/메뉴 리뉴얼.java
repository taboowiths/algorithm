import java.util.*;
class Solution {
    static HashMap<String, Integer> map;
    static int max;
    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                set.add(orders[i].charAt(j));
            }
        }
        char[] alpha = new char[set.size()];
        int i = 0;
        for(Character ch : set) {
            alpha[i++] = ch;
        }
        for (int j = 0; j < course.length; j++) {
            max = 0;
            map = new HashMap<>();
            comb(0, 0, course[j], "", alpha, orders);
//            System.out.println(max);
            for (String s : map.keySet()) {
                if (map.get(s) == max) ans.add(s);
            }
        }
        Collections.sort(ans);
//        System.out.println(ans);
        String[] answer = new String[ans.size()];
        i = 0;
        for (int j = 0; j < ans.size(); j++) {
            answer[i++] = ans.get(j);
        }
        return answer;
    }

    public static void comb (int cnt, int start, int N, String s, char[] alpha, String[] orders) {
        if (cnt == N) {
            int pass = getCourse(s, orders);
            max = Math.max(pass, max);
            return;
        }

        for (int i = start; i < alpha.length; i++) {
            comb(cnt+1, i+1, N, s+alpha[i], alpha, orders);
        }
    }

    public static int getCourse (String s, String[] orders) {
        int pass = 0;
        for (int i = 0; i < orders.length; i++) {
            if (isContain(s, orders[i])) pass++;
        }
        if (pass > 1) {
            map.put(s, pass);
        }
        return pass;
    }

    public static boolean isContain (String s, String order) {
        char[] chars = s.toCharArray();

        for (int j = 0; j < chars.length; j++) {
            if (!order.contains(String.valueOf(chars[j]))) return false;
        }

        return true;
    }
}