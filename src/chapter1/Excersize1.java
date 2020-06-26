package chapter1;

import java.util.Scanner;

public class Excersize1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.printf("0b%2$s, 0x%1$X, 0o%1$o\n", num, Integer.toBinaryString(num));
    }
}
