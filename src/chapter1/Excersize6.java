package chapter1;

import java.math.BigInteger;

public class Excersize6 {
    public static void main(String[] args) {
        printFactorial(10000);
    }

    static void printFactorial(int n) {
        BigInteger fac = factorial(n);
        System.out.printf("Factorial of %d is %s\n", n, fac.toString());
    }

    static BigInteger factorial(int n) {
        BigInteger fac = BigInteger.ONE;
        for (long i = 1; i <= n; ++i) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }
        return fac;
    }
}
