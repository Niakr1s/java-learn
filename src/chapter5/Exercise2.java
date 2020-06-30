package chapter5;

import java.io.FileNotFoundException;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        String filename = "src/chapter5/validValues.txt";
        try {
            System.out.println(sumOfValues(filename));
        } catch (FileNotFoundException e) {
            System.out.printf("File %s not found\n", filename);
        } catch (NumberFormatException e) {
            System.out.printf("Found non-numbers in file %s\n", filename);
        }
    }

    public static double sumOfValues(String filename) throws FileNotFoundException, NumberFormatException {
        List<Double> list = Exercise1.readValues(filename);
        double sum = 0;
        for (double n : list) {
            sum += n;
        }
        return sum;
    }
}
