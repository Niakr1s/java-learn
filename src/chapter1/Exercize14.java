package chapter1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercize14 {
    public static void main(String[] args) {
        List<List<Integer>> arr = readArray(new Scanner(System.in));
        if (isMagic(arr)) {
            System.out.println("You have entered magic square :)");
        } else {
            System.out.println("You have entered non-magic square :(");
        }
    }

    static List<List<Integer>> readArray(Scanner in) {
        List<List<Integer>> res = new ArrayList<>();
        while (in.hasNextLine()) {
            List<Integer> row = new ArrayList<>();
            String line = in.nextLine();
            if (line.isBlank()) {
                return res;
            }
            String[] words = line.split("\\s+");
            for (String word : words) {
                int i = Integer.parseInt(word);
                row.add(i);
            }
            res.add(row);
        }
        return res;
    }

    static boolean isSquare(List<List<Integer>> arr) {
        int l = arr.size();
        for (List<Integer> row : arr) {
            if (row.size() != l) {
                return false;
            }
        }
        return true;
    }

    static boolean isMagic(List<List<Integer>> arr) {
        if (!isSquare(arr) || arr.size() == 0) {
            return false;
        }
        int sum = getSum(arr.get(0));
        // starting from 1 because sum was already calculated from 0 row
        for (int row = 1; row < arr.size(); row++) {
            if (getSum(arr.get(row)) != sum) {
                return false;
            }
        }
        for (int col = 0; col < arr.get(0).size(); col++) {
            List<Integer> column = new ArrayList<>();
            for (List<Integer> row : arr) {
                column.add(row.get(col));
            }
            if (getSum(column) != sum) {
                return false;
            }
        }
        List<Integer> diag = new ArrayList<>();
        List<Integer> diag2 = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            diag.add(arr.get(i).get(i));
            diag2.add(arr.get(arr.size()-1-i).get(i));
        }
        if (getSum(diag) != sum || getSum(diag2) != sum) {
            return false;
        }
        return true;
    }

    static int getSum(List<Integer> arr) {
        return arr.stream().reduce(0, Integer::sum);
    }
}
