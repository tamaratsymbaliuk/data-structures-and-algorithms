public class FibonacciNumber_509 {
    private int[] f; // Cache array

    public int fib(int n) {
        f = new int[n + 1]; // 0..n
        return fib_(n);
    }

    private int fib_(int n) {
        if (n <= 1) return n;
        if (f[n] == 0) { // Only compute if not cached
            f[n] = fib_(n - 1) + fib_(n - 2);
        }
        return f[n];
    }


    public static void main(String[] args) {
        FibonacciNumber_509 test = new FibonacciNumber_509();
        int n = test.fib(7);
        System.out.println(n);
    }
}
