package chapter1;

public class Exercize16 {
    public static void main(String[] args) {
        System.out.printf("avg = %d\n", average(3, 6, 3, 2));
    }

    static int average(int first, int ... ints) {
        int avg = first;
        for (int i: ints) {
            avg += i;
        }
        return avg;
    }
}
