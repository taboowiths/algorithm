package bj;

import java.util.*;
import java.io.*;
public class Main_bj_1755_숫자놀이 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); // M부터 N까지 입력 받음.
        int N = Integer.parseInt(st.nextToken());
        String[] alpha = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"}; // 정렬 비교에 사용할 알파벳 순서.
        HashMap<String, Integer> map = new HashMap<>(); // 영어 단어와 숫자를 Map으로 관리함.
        String[] sort = new String[N-M+1]; // 영어 단어 저장할 배열.
        ArrayList<Integer> list = new ArrayList<>(); // 숫자 저장할 Arraylist.

        for (int i = M; i <= N; i++) {
            String num;
            if (i >= 10) { // 십의 자리 이상이면 십의자리+일의자리 따로 영단어 만들어줌.
                num = alpha[(i/10)] + alpha[(i%10)];
            } else { // 일의자리면 영단어 그대로 저장.
                num = alpha[(i%10)];
            }
            sort[i-M] = num; // 영단어만 배열에 저장.
            map.put(num, i); // 영단어, 숫자 연결하여 저장.
        }
        Arrays.sort(sort); // 영단어 사전 순서로 정렬.
        for (int i = 0; i < N-M+1; i++) {
            list.add(map.get(sort[i])); // 정렬된 영단어를 KEY로 하여 숫자를 뽑아, Arraylist에 저장.
        }

        for (int i = 0; i < list.size(); i++) {
            if (i>0&&i%10==0) System.out.println(); // i가 0 초과, 10의 배수면 줄바꿈.
            System.out.print(list.get(i) + " "); // Arraylist에 저장된 숫자를 출력함.
        }
        br.close();
    }
}
