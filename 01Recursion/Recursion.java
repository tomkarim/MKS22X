public class Recursion {
    public Recursion() {

    }

    public int fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be negative!");
        }
        if (n == 0) {
            return 1;
        }
        return n * (fact(n - 1));
    }

    public int fib(int n) {
        int fib[] = new int[n + 1];
        if (n < 0) {
            throw new IllegalArgumentException("N can't be negative!");
        }
        if (n <= 1){
            return n;
        }
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }
        return fib[n];
    }

    public double sqrt(double n) {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be negative!");
        }
        return sqrtHelp(n, 1);
    }

    public double sqrtHelp(double n, double guess) {
        if (n == 0) {
            return 0;
        }
        if (Math.abs(guess * guess - n) < n / 10000000) {
            return guess;
        }
        return sqrtHelp(n, ((n / guess) + guess) / 2);
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println(r.fact(0));
        System.out.println(r.fact(1));
        System.out.println(r.fact(10));
        System.out.println(r.fact(1000));
        System.out.println(r.fib(0));
        System.out.println(r.fib(1));
        System.out.println(r.fib(10));
        System.out.println(r.fib(100000));
        System.out.println(r.sqrt(0));
        System.out.println(r.sqrt(1));
        System.out.println(r.sqrt(10));
        System.out.println(r.sqrt(1000000));
    }
}