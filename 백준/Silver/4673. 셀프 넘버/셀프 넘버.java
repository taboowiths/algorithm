public class Main {
    public static void main(String[] args) throws Exception {
        boolean[] check = new boolean[10001];
        for (int i = 1; i < 10000; i++) {
            int num = d(i);
            if (num < 10000) {
                check[num] = true;
            }
        }
        for (int i = 1; i < 10000; i++) {
            if (!check[i]) System.out.println(i);
        }
    }

    public static int d(int n) {
        int num = n;
        while (n > 0) {
            num += (n % 10);
            n /= 10;
        }
        return num;
    }
}
