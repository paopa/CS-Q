package cs.algorithm.microsoft.bing.bigman;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;

/**
 * 2 2
 * 3 3
 * 4 5
 * 5 8
 * 6 13
 * 7 21
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            Application.start();
        }
    }
}

class Application {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int stairs = Integer.parseInt(scanner.next());
        if (stairs < 0 || stairs > 1_000_000_000) {
            throw new IllegalArgumentException();
        }
//        System.out.println(fib2(stairs).mod(new BigInteger("1000000007")));
//        System.out.println(fib5(stairs).mod(new BigInteger("1000000007")));
//        System.out.println(fib4(stairs).mod(new BigInteger("1000000007")));
    }

    static BigInteger fib5(int n)
    {
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(1);
        for (int j=2 ; j<=n ; j++)
        {
            c =  a.add(b);
            a = b;
            b = c;
        }

        return (b);
    }

    static BigInteger fib4(int n) {
        if (n <= 2) {
            return new BigInteger(String.valueOf(n));
        }
        BigInteger[] x = new BigInteger[n + 1];
        x[1] = new BigInteger("1");
        x[2] = new BigInteger("2");
        for (int i = 3; i <= n; i++) {
            x[i] = x[i - 1].add(x[i - 2]);
        }
        return x[n];
    }

    static BigInteger fib3(int n) {
        String phi = String.valueOf((1 + Math.sqrt(5)) / 2);
        BigDecimal x = new BigDecimal(phi);
//        return Math.round(Math.pow(phi, n)/ Math.sqrt(5));
        return x.pow(n).divide(new BigDecimal("5")
                .sqrt(new MathContext(10))).round(new MathContext(0)).toBigInteger();
    }

    static BigInteger fib2(int n) {
        BigInteger[][] F = new BigInteger[][]{{new BigInteger("1"), new BigInteger("1")}, {new BigInteger("1"), new BigInteger("0")}};
        if (n == 0) {
            return new BigInteger("0");
        }
        power(F, n);
        return F[0][0];
    }

    static void power(BigInteger[][] F, int n) {
        int i;
        BigInteger[][] M = new BigInteger[][]{{new BigInteger("1"), new BigInteger("1")}, {new BigInteger("1"), new BigInteger("0")}};
        for (i = 2; i <= n; i++) {
            multiply(F, M);
        }
    }

    static void multiply(BigInteger[][] F, BigInteger[][] M) {
        BigInteger x = F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0]));
        BigInteger y = F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]));
        BigInteger z = F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]));
        BigInteger w = F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]));

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    private static int fib1(int stairs) {
        if (stairs <= 2) {
            return stairs;
        }
        return fib1(stairs - 1) + fib1(stairs - 2);
    }

}