package chapter7;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise3 {
    public static void main(String[] args) {
        Set<Integer> intersection = makeSet1();
        intersection.retainAll(makeSet2());
        System.out.println(intersection);

        Set<Integer> union = makeSet1();
        union.addAll(makeSet2());
        System.out.println(union);

        Set<Integer> difference = makeSet1();
        difference.removeAll(makeSet2());
        Set<Integer> set2 = makeSet2();
        set2.removeAll(makeSet1());
        difference.addAll(set2);
        System.out.println(difference);
    }

    private static Set<Integer> makeSet1() {
        return new HashSet<>(List.of(1, 2, 3));
    }
    private static Set<Integer> makeSet2() {
        return new HashSet<>(List.of(3, 4, 5));
    }
}
