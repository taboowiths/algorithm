import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (value1, value2) -> (map.get(value1).compareTo(map.get(value2))));
        int prev = 0;
        int result = 0;
        for (Integer key : list) {
            prev += map.get(key);
            result += prev;
        }
        System.out.println(result);
        br.close();
    }
}
