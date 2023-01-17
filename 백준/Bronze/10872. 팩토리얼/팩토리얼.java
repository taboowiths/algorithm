import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(N));
        br.close();
    }

    public static int factorial (int n) {
        if (n == 0) return 1;
        else if (n <= 1) return n;
        else return factorial(n-1)*n;
    }
}