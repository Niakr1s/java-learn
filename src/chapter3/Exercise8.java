package chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise8 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 2, 10));
        luckySort(list);
        System.out.println(list);
    }

    public static void luckySort(List<Integer> list) {
        List<Integer> etalon = new ArrayList<>(list);
        etalon.sort(Integer::compareTo);
        while (!list.equals(etalon)) {
            Collections.shuffle(list);
        }
    }
}
