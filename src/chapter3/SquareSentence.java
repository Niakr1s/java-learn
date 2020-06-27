package chapter3;

import java.math.BigInteger;
import java.util.Iterator;

public class SquareSentence implements Iterator<BigInteger> {
    private BigInteger current = BigInteger.valueOf(0);

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public BigInteger next() {
        var res = current.multiply(current);
        current = current.add(BigInteger.ONE);
        return res;
    }
}
