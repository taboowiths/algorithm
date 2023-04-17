import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int start_x = 0; 
        int start_y = 0;
        int N = park.length; int M = park[0].length();
        for (int i=0; i<park.length; i++) {
            for (int j=0; j<park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    start_x=i; start_y=j;
                }
            }
        }
        for (int i=0; i<routes.length; i++) {
            String[] order = routes[i].split(" ");
            int step = Integer.parseInt(order[1]);
            switch (order[0]) {
                case "N": 
                    loop: if (start_x-step >= 0) {
                        for (int j=1; j<=step; j++) {
                            if (park[start_x-j].charAt(start_y) == 'X') break loop;
                        }
                        start_x -= step;
                    }
                    break;
                case "S":
                    loop: if (start_x+step < N) {
                        for (int j=1; j<=step; j++) {
                            if (park[start_x+j].charAt(start_y) == 'X') break loop;
                        }
                        start_x += step;
                    }
                    break;
                case "W":
                    loop: if (start_y-step >= 0) {
                        for (int j=1; j<=step; j++) {
                            if (park[start_x].charAt(start_y-j) == 'X') break loop;
                        }
                        start_y -= step;
                    }
                    break;
                case "E":
                    loop: if (start_y+step < M) {
                        for (int j=1; j<=step; j++) {
                            if (park[start_x].charAt(start_y+j) == 'X') break loop;
                        }
                        start_y += step;
                    }
                    break;
            }
        }
        answer = new int[]{start_x, start_y};   
        return answer;
    }
}