package chapter2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class YearPrinter {
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            printMonth(1988, i);
            System.out.println();
        }
    }

    static void printMonth(int year, int month) {
        final Month currentMonth = Month.of(month);
        System.out.println(currentMonth.getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("ru")));
        printDaysOfWeek();
        final Month nextMonth = currentMonth.plus(1);
        LocalDate date = getPrevMonday(year, month);
        while (!(date.getMonth() == nextMonth && date.getDayOfWeek() == DayOfWeek.MONDAY)) {
            System.out.printf("%3d ", date.getDayOfMonth());
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
    }

    static LocalDate getPrevMonday(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        while (date.getDayOfWeek() != DayOfWeek.MONDAY) {
            date = date.minusDays(1);
        }
        return date;
    }

    static void printDaysOfWeek() {
        DayOfWeek dayOfWeak = DayOfWeek.MONDAY;
        do {
            System.out.printf("%3s ", dayOfWeak.getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("ru")));
            dayOfWeak = dayOfWeak.plus(1);
        } while (dayOfWeak != DayOfWeek.MONDAY);
        System.out.println();
    }
}
