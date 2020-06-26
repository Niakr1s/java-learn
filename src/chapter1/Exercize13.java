package chapter1;

import java.util.*;

public class Exercize13 {
    static final int WIN_SIZE = 7;
    static final int SIZE = 49;

    public static void main(String[] args) {
        System.out.println(pickWinCombination());
    }

    static List<Integer> generateArray() {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= SIZE; ++i) {
            res.add(i);
        }
        return res;
    }

    /**
     * @return sorted win combination
     */
    static List<Integer> pickWinCombination() {
        List<Integer> arr = generateArray();
        Collections.shuffle(arr);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < WIN_SIZE && i < arr.size(); i++) {
            res.add(arr.get(i));
        }
        res.sort(Comparator.comparingInt(o -> o));
        return res;
    }
}
