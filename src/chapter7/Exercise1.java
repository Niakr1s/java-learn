package chapter7;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Supplier;

public class Exercise1 {
    public static void main(String[] args) {
        final int times = 1_000_000;
        System.out.println(bench(() -> new HashSetSieve(times)));
        System.out.println(bench(() -> new BitSetSieve(times)));
    }

    private static int bench(Supplier<Sieve> constructor) {
        long start = System.currentTimeMillis();
        Sieve sieve = constructor.get();
        sieve.sieve();
        long end = System.currentTimeMillis();
        return (int) (end - start);
    }
}
