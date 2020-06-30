package chapter5;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        copyFileWithTry();
    }

    public static void copyFileWithTry() {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("src/chapter5/validValues.txt"));
            out = new PrintWriter("src/chapter5/validValues - copy.txt");
            while (in.hasNextLine()) {
                out.println(in.nextLine());
            }
        } catch (IOException e) {
            System.out.println("in file not found");
        } catch (IllegalStateException e) {
            System.out.printf("error: %s\n", e);
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IllegalStateException ignored) {
            }
        }
    }

    public static void copyFileWithTryWithResources() {
        try (Scanner in = new Scanner(Paths.get("src/chapter5/validValues.txt"));
             PrintWriter out = new PrintWriter("src/chapter5/validValues - copy.txt")) {
            while (in.hasNextLine()) {
                out.println(in.nextLine());
            }
        } catch (IOException e) {
            System.out.println("in file not found");
        } catch (IllegalStateException e) {
            System.out.printf("error: %s\n", e);
        }
    }
}
