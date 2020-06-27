package chapter3;

import java.util.Iterator;

public class Exercise3 {
    public static void main(String[] args) {
        Iterator<Integer> seq = IntSequence.of(1, 5, 2, 3);
        while (seq.hasNext()) {
            System.out.println(seq.next());
        }
    }
}
