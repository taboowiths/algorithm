import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (!map.containsKey(name)) {
                map.put(name, 1);
            } else {
                map.put(name, 2);
            }
        }
        int cnt = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) > 1) {
                cnt++;
                list.add(s);
            }
        }
        Collections.sort(list);
        for (String s : list) {
            res.append(s).append("\n");
        }
        System.out.println(cnt);
        System.out.println(res.toString());
        br.close();
    }
}
