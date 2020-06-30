package chapter7;

import java.util.*;

public abstract class Sieve {
    protected final int maxNumber;

    Sieve(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void sieve() {
        int min = 2;
        while (min * min < maxNumber) {
            int multiplier = min;
            while (min * multiplier < maxNumber) {
                removeNumber(min * multiplier);
                multiplier++;
            }
            min++;
        }
    }

    public Integer[] getResult() {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= maxNumber; i++) {
            if (hasNumber(i)) res.add(i);
        }
        return res.toArray(Integer[]::new);
    }

    protected abstract void removeNumber(int num);

    protected abstract boolean hasNumber(int num);
}

class HashSetSieve extends Sieve {
    private Set<Integer> set;

    public HashSetSieve(int n) {
        super(n);
        set = new HashSet<>(n + 1);
        for (int i = 2; i <= n; i++) {
            set.add(i);
        }
    }

    @Override
    protected void removeNumber(int num) {
        set.remove(num);
    }

    @Override
    protected boolean hasNumber(int num) {
        return set.contains(num);
    }
}

class BitSetSieve extends Sieve {
    /**
     * Default value (false) - have number, othervise - doesn't have number.
     * Number = index.
     */
    private BitSet set;

    BitSetSieve(int num) {
        super(num);
        set = new BitSet(num + 1);
    }

    @Override
    protected void removeNumber(int num) {
        set.set(num, true);
    }

    @Override
    protected boolean hasNumber(int num) {
        return !set.get(num);
    }
}