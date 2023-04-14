import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> names = new HashMap<>();
        HashMap<Integer, String> numbers = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            names.put(players[i], i);
            numbers.put(i, players[i]);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String name = callings[i];
            int number = names.get(name); 
            
            String tmpName = numbers.get(number-1); // 앞 사람 이름
            int tmpNum = names.get(tmpName); // 앞 사람 번호
            
            names.put(tmpName, number);
            names.put(name, tmpNum);
            numbers.put(tmpNum, name);
            numbers.put(number, tmpName);
            
            
        }
        // int idx = 1;
        for (int i = 0; i < numbers.size(); i++ ) {
            answer[i] = numbers.get(i);
            // idx++;
        }
        return answer;
    }
}