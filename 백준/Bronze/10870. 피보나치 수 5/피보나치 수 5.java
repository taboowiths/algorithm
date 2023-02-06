import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Fibonacci(N));
    }

    public static int Fibonacci (int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return Fibonacci(n-1) + Fibonacci(n-2);
    }
}