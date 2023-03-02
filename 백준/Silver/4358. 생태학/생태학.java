import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        String s;
        int cnt = 0;
        while ((s = br.readLine()) != null) {
            cnt++;
            if (!map.containsKey(s)) map.put(s, 1);
            else map.put(s, map.get(s)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String name : list) {
            sb.append(name).append(" ").append(String.format("%.4f", map.get(name)*100 / (double) cnt)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
