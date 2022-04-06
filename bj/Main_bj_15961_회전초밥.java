package bj;
import java.util.*;
import java.io.*;
public class Main_bj_15961_회전초밥 {

    static int N, d, k, c, ate[], tb[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
        k = Integer.parseInt(st.nextToken()); // 연속한 접시 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        tb = new int[N];
        for (int i = 0; i < N; i++) {
            tb[i] = Integer.parseInt(br.readLine());
        }
        ate = new int[d+1]; // 마지막 종류까지 저장
        System.out.println(getDishes());
        br.close();
    }

    static int getDishes () {
        int max = 0, kind = 0;
        for (int i = 0; i < k; i++) {
            if (ate[tb[i]] == 0) kind++; // 처음 먹는 종류의 초밥이면 종류 더함.
            ate[tb[i]]++; // 먹은 초밥의 종류 표시.
        }
        max = kind;
        for (int i = 1; i < N; i++) {
            int front = tb[i-1]; // 맨 앞 빠질 초밥
            if (--ate[front] == 0) kind--; // 먹은 초밥을 빼고 난 후 0이면 종류도 뺌.
            int end = (i + k - 1) % N; // 마지막 초밥의 인덱스 (회전초밥이므로 N을 넘어가면 맨 앞의 값)
            if (ate[tb[end]] == 0) kind++;
            ate[tb[end]]++;

            // 먹은 종류가 많아지거나 같아지면, 쿠폰 반영해서 max값 갱신.
           if (max <= kind) {
                if (ate[c] == 0) { // 쿠폰의 초밥이 먹지 않은 종류면 종류 더함.
                    max = kind+1;
                } else {
                    max = kind;
                }
            }
        }
        return max;
    }
}


/*
8 30 4 30
7
9
7
30
2
7
9
25
--> 5

8 50 4 7
2
7
9
25
7
9
7
30
--> 4
*/
