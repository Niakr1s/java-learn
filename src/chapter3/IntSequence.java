package chapter3;

import java.util.Iterator;

public class IntSequence {
    @SafeVarargs
    public static <T> Iterator<T> of(T... ints) {
        return new Iterator<T>() {
            private int nextIdx = 0;

            @Override
            public boolean hasNext() {
                return nextIdx < ints.length;
            }

            @Override
            public T next() {
                return ints[nextIdx++];
            }
        };
    }

    public static Iterator<Integer> constant(int n) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return 1;
            }
        };
    }
}
