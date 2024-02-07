import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb;
        int N = 0;
        int min = Integer.MAX_VALUE;
        
        while (N++ < s.length()) {
            // N개 단위로 문자열 자르기
            int start = 0;
            int end = start+N;
            int cnt = 1;
            sb = new StringBuilder();

            while (end <= s.length()) {
                String str = s.substring(start, end); // 얘가 있는지
//                System.out.println("str: " + str);
                while (end+N <= s.length()) {
                    int ns = start + N;
                    int ne = end + N;
                    String next = s.substring(ns, ne);
//                    System.out.println("next: " + next);
                    if (str.equals(next)) {
                        cnt++;
                        start = ns;
                        end = ne;
//                        System.out.println("nextIdx: " + ns + " " + ne);
                    } else break;
                }
                if (cnt == 1) sb.append(str);
                else sb.append(cnt).append(str);
                cnt = 1;
                start += N;
                end += N;
            }
           sb.append(s.substring(start));
            min = Math.min(sb.length(), min);
//            System.out.println("N: " + N + ", sb: " +  sb);
//            System.out.println(sb.length());
//            System.out.println();
        }
        
        return min;
    }
}