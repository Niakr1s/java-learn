package chapter1;

import java.util.Random;

public class Excersize10 {
    public static void main(String[] args) {
        Random rand = new Random();
        long num = Math.abs(rand.nextLong());
        System.out.println(Long.toString(num, 36));
    }
}
