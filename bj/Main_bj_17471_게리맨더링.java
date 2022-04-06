package bj;
import java.io.*;
import java.util.*;

public class Main_bj_17471_게리맨더링 {
    static List<Integer> list[];
    static int N, min, person[];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_bj_17471.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        person = new int[N+1];
        ArrayList<Integer> numbers = new ArrayList<>();
        list = new List[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            person[i] = Integer.parseInt(st.nextToken()); // i번 구역의 인구 : person[i]
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken()); // 연결된 정점의 개수
            for (int j = 0; j < num; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        // if n == 6 , 1개-5개 ~ 3개-3개 뽑기
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N/2; i++) {
            divide(0, 1, i, numbers);
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
        br.close();
    }

    // 조합으로 구역 나누기 : 무조건 다 뽑아야 함, 순서 중요 X
    static void divide (int cnt, int start, int R, ArrayList<Integer> numbers) {
        if (cnt == R) {
            calc(numbers);
            return;
        }
        for (int i = start; i <= N; i++) {
            numbers.add(i);
            divide(cnt+1, i+1, R, numbers);
            numbers.remove(numbers.size()-1);
        }
    }

    // 나뉜 구역이 연결되었는지 확인 : BFS
    static boolean checkCon (ArrayList<Integer> numbers) {
        if (numbers.size() == 1) return true;
        Queue<Integer> queue= new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        int i = numbers.get(0);
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            i = queue.poll();
            for (int j : list[i]) {
                if (!visited[j] && numbers.contains(i)) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
        for (int n = 0; n < numbers.size(); n++) {
            for (int k = 1; k <= N; k++) {
                if (!visited[numbers.get(n)]) return false;
            }
        }
        return true;
    }

    static void calc (ArrayList<Integer> numbers) { // 각 선거구의 인구 구하기
        // A 구역 확인
        if (!checkCon(numbers)) {
            return;
        }
        // B 그룹 생성
        ArrayList<Integer> bgroup = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (numbers.contains(i)) continue;
            bgroup.add(i);
        }
        if (!checkCon(bgroup)) {
            return;
        }

        // A, B 모두 성립 -> 선거인수 계산
        int a = 0, b = 0;
        for (int i = 0; i < numbers.size(); i++) {
            a += person[numbers.get(i)];
        }
        for (int i = 0; i < bgroup.size(); i++) {
            b += person[bgroup.get(i)];
        }
        min = Math.min(min, Math.abs(a - b));
    }
}
