import java.util.*;

class Solution {
    public static String[] solution (String[] record) {
        HashMap<String, String> map = new HashMap<>();
        StringTokenizer st;

        int cnt = 0;
        for (int i = 0; i < record.length; i++) {
            String word, id, nickname = "";
            st = new StringTokenizer(record[i], " ");
            word = st.nextToken();
            id = st.nextToken();
            if (!word.equals("Change")) cnt++;
            if (!word.equals("Leave")){
                nickname = st.nextToken();
                map.put(id, nickname);
            }
        }

        int idx = 0;
        String[] answer = new String[cnt];
        for (int i = 0; i < record.length; i++) {
            String word, id, nickname = "";
            st = new StringTokenizer(record[i], " ");
            word = st.nextToken();
            id = st.nextToken();
            if (!word.equals("Leave")) nickname = st.nextToken();

            String s = "";
            String name = "";
            if (!word.equals("Change")) {
                name = map.get(id);
                if (word.equals("Enter")) {
                    s = name + "님이 들어왔습니다.";
                } else {
                    s = name + "님이 나갔습니다.";
                }
            } else continue;
            answer[idx++] = s;
        }

        return answer;
    }
}