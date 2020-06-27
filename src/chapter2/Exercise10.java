package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise10 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.printf("random from empty list = %d\n", RandomNumbers.getRandomFrom(list));
        list.add(2);
        list.add(5);
        System.out.printf("random from non-empty list = %d\n", RandomNumbers.getRandomFrom(list));
        System.out.printf("random from non-empty list = %d\n", RandomNumbers.getRandomFrom(list));
        System.out.printf("random from non-empty list = %d\n", RandomNumbers.getRandomFrom(list));
    }
}

class RandomNumbers {
    static Random gen = new Random();

    public static int getRandomFrom(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int idx = gen.nextInt(list.size());
        return list.get(idx);
    }

    public static int getRandomFrom(Integer[] list) {
        return getRandomFrom(List.of(list));
    }
}
