package chapter3;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise13 {
    public static void main(String[] args) {
        File[] files = new File("c:/").listFiles();
        if (files == null) {
            files = new File[0];
        }
        Arrays.sort(files, Comparator.comparing(File::isFile).thenComparing(File::getName, String::compareTo));
        System.out.println(Arrays.toString(files));
    }
}
