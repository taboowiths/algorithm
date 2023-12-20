import java.util.*;

class Solution {
    static int N, result;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        N = words.length;
        result = 0;
        if (begin.compareTo(target) < 0) { // begin < target
            Arrays.sort(words);
        } else {
            Arrays.sort(words, Collections.reverseOrder());
        }
        visited = new boolean[N];
        dfs(0, 0, begin, target, words);

        return result;
    }
    
    public static void dfs (int cnt, int stage, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            result = stage;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (!isDiffInOne(begin, words[i])) continue;
                visited[i] = true;
                dfs(cnt+1, stage+1, words[i], target, words);
                visited[i] = false;
            }
        }
        
    }
    
    public static boolean isDiffInOne (String s1, String s2) {
        if (s1.equals(s2)) return false;
        int diffCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diffCnt++;
        }
        return diffCnt == 1;
    }
}