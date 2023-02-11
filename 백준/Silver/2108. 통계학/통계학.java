import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] inputs = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            inputs[i] = input;
            sum += input;
            max = Math.max(input, max);
            min = Math.min(input, min);
            if (!map.containsKey(input)) map.put(input, 1);
            else map.put(input, map.get(input)+1);
        }
        Arrays.sort(inputs);
        List<Integer> list = new ArrayList<>(map.keySet());
        List<Integer> subList = new ArrayList<>();
        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int value = map.get(list.get(0));
        for (Integer i : list) {
            if (map.get(i) == value) {
                subList.add(i);
            }
        }
        Collections.sort(subList);

        System.out.println(Math.round(sum/N));
        System.out.println(inputs[N/2]);
        if (subList.size() > 1) System.out.println(subList.get(1));
        else System.out.println(list.get(0));
        System.out.println(max-min);
    }
}