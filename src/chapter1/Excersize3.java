package chapter1;

import java.util.Scanner;

public class Excersize3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ints = new int[3];
        for (int i = 0; i < ints.length; ++i) {
            ints[i] = in.nextInt();
        }
        System.out.printf("max = %d\n", max(ints));
    }

    static int max(int ... ints) {
        if (ints.length == 0) {
            return 0;
        }
        int m = ints[0];
        for (int i : ints) {
            if (i > m ) {
                m = i;
            }
        }
        return m;
    }
}
