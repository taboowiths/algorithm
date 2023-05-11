import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int[][] times = new int[3][2];
        for (int i = 0; i < 3; i++) {
            String[] time = inputs[i].split(":");
            times[i][0] = Integer.parseInt(time[0]);
            times[i][1] = Integer.parseInt(time[1]);
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        while (true) {
            String info = br.readLine();
            if (info==null) break;
            String[] infos = info.split(" ");
            if (map.containsKey(infos[1])) map.get(infos[1]).add(infos[0]);
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(infos[0]);
                map.put(infos[1], list);
            }
        }
        
        int cnt = 0;
        for (ArrayList<String> list : map.values()) {
            int len = list.size();
            if (len < 2) continue;
            int e_h = Integer.parseInt(list.get(0).split(":")[0]);
            int e_m = Integer.parseInt(list.get(0).split(":")[1]);
            if (e_h > times[0][0] || (e_h == times[0][0] && e_m > times[0][1])) continue; // 개총 시작보다 늦음

            boolean flag = false;
            for (int i = 1; i < len; i++) {
                String time = list.get(i);
                int h = Integer.parseInt(time.split(":")[0]);
                int m = Integer.parseInt(time.split(":")[1]);
                if (h < times[1][0] || (h == times[1][0] && m < times[1][1])) continue; // 개총 진행 중에 나감
                if (h > times[2][0] || (h == times[2][0] && m > times[2][1])) continue; // 스트리밍 종료 후 댓글 남김
                flag = true;
            }
            if (flag) cnt++;
        }
        System.out.println(cnt);
    }
}
