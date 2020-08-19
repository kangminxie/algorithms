package com.kangmin.algo.csce.recursion;

public final class SimpleRecursive {
    private static void countDown(int number) {
        if (number < 0) {
            return;
        }
        System.out.println(number);
        countDown(number - 1);
    }

    private static int factorial(int n) {
        // not going to deal with n < 0 case
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    private static int fibo(int n) {
        // not going to deal with n < 0 case
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(final String[] args) {
        countDown(5);
        System.out.println(factorial(5));
        System.out.println(gcd(45, 81));
        System.out.println(fibo(9));
    }
}
