import java.util.*;

class Solution {
    static String[] selected;
    static boolean[] visited;
    static HashSet<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        
        visited = new boolean[user_id.length];
        set = new HashSet<>();

        dfs(0, user_id, banned_id);
        System.out.println(set);
        
        return set.size();
    }
    
    public static void dfs (int cnt, String[] user_id, String[] banned_id) {
        if (cnt == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) sb.append(user_id[i]);
            }
            // System.out.println(list);
            set.add(sb.toString());
            return;
        }
        
        for (int j = 0; j < user_id.length; j++) {
            if (isBanned(user_id[j], banned_id[cnt]) && !visited[j]) {
                visited[j] = true;
                dfs (cnt+1, user_id, banned_id);
                visited[j] = false;
            }
        }
    }
    
    public static boolean isBanned (String user, String banned) {
        if (banned.length() != user.length()) return false;
        for (int k = 0; k < banned.length(); k++) {
            if (banned.charAt(k) == '*') continue;
            if (banned.charAt(k) != user.charAt(k)) return false;
        }
        return true;
    }
}
