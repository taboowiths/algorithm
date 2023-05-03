import java.util.*;

class Solution {   
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static ArrayList<String> list;
    
    public int solution(String[][] relation) {
        N = relation[0].length;
        numbers = new int[N];
        visited = new boolean[N];
        list = new ArrayList<>();
        subset(0);
        list.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        System.out.println(list);
        int answer = checkUni(relation);        
        return answer;
    }
    
    public void subset (int cnt) {
        if (cnt == N) {
            String s = "";
            for (int i = 0; i < N; i++) {
                if (visited[i]) s+=i;
            }
            list.add(s);
            return;
        }

        visited[cnt] = true;
        subset(cnt+1);
        visited[cnt] = false;
        subset(cnt+1);
    }
    
    public int checkUni (String[][] relation) {
        ArrayList<String> checkUni = new ArrayList<>();
        for (String check : list) {
            HashSet<String> set = new HashSet<>();
            if (!check.equals("")) {
                for (int i = 0; i < relation.length; i++) {
                    String s = "";
                    for (int j = 0; j < check.length(); j++) {
                        s += relation[i][check.charAt(j) - '0'];
                    }
                    set.add(s);
                }
            }
            if (set.size() == relation.length) checkUni.add(check);
        }
        return checkMin(checkUni);
    }
    
    public static int checkMin (ArrayList<String> checkUni) {
        int size = checkUni.size();
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                int cnt = 0;
                String s = checkUni.get(i);
                for (int k = 0; k < s.length(); k++) {
//                    System.out.println("비교값: " + checkUni.get(j));
//                    System.out.println("check: " + s.charAt(k));
                    if (checkUni.get(j).contains(String.valueOf(s.charAt(k)))) cnt++;
                }
//                if (checkUni.get(j).contains(checkUni.get(i))) cnt++;
                if (cnt == s.length()) {
                    // System.out.println("제거: " + checkUni.get(j));
                    checkUni.remove(j);
                    size--;
                    j--;
                }
//                System.out.println("-----------next");
            }
        }
//        System.out.println(checkUni);
        return checkUni.size();
    }
}