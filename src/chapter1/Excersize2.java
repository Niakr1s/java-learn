package chapter1;

import java.util.Scanner;

public class Excersize2 {
    public static void main(String[] args) {
        int angle = new Scanner(System.in).nextInt();
        int normalizedAngle = Math.floorMod(angle , 360);
        System.out.println(normalizedAngle);
    }
}
