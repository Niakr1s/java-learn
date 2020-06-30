package chapter5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        try {
            System.out.println(readValues("src/chapter5/Exercise1.java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Double> readValues(String filename) throws FileNotFoundException, NumberFormatException {
        FileReader fileReader = new FileReader(filename);
        try (Scanner in = new Scanner(fileReader)) {
            ArrayList<Double> res = new ArrayList<>();
            while (in.hasNext()) {
                String next = in.next();
                double nextDouble = Double.parseDouble(next);
                res.add(nextDouble);
            }
            return res;
        }
    }
}
