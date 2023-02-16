import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int idx = 0;
            while (s.charAt(idx) != '.') idx++;
            String ext = s.substring(idx+1, s.length());
            if (!map.containsKey(ext)) map.put(ext, 1);
            else map.put(ext, map.get(ext)+1);
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for (String key : keyList) {
            System.out.println(key + " " + map.get(key));
        }
        br.close();
    }
}
