package chapter2;

import java.time.DayOfWeek;

public class Exercize1 {
    public static void main(String[] args) {
        new YearPrinter(DayOfWeek.MONDAY).printYear(1988);
        System.out.println("-----------------------");
        new YearPrinter(DayOfWeek.SUNDAY).printYear(1988);
    }
}
