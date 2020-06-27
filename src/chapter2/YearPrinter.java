package chapter2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class YearPrinter {
    private final DayOfWeek startingDay;

    public YearPrinter() {
        this(DayOfWeek.MONDAY);
    }

    public YearPrinter(DayOfWeek startingDay) {
        this.startingDay = startingDay;
    }

    public void printYear(int year) {
        for (int i = 1; i <= 12; i++) {
            printMonth(year, i);
            System.out.println();
        }
    }

    private void printMonth(int year, int month) {
        final Month currentMonth = Month.of(month);
        System.out.println(currentMonth.getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("ru")));
        printDaysOfWeek();
        final Month nextMonth = currentMonth.plus(1);
        LocalDate date = getPrevStart(year, month);
        while (!(date.getMonth() == nextMonth && date.getDayOfWeek() == this.startingDay)) {
            System.out.printf("%3d ", date.getDayOfMonth());
            if (date.getDayOfWeek() == this.startingDay.minus(1)) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
    }

    private LocalDate getPrevStart(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        while (date.getDayOfWeek() != this.startingDay) {
            date = date.minusDays(1);
        }
        return date;
    }

    private void printDaysOfWeek() {
        DayOfWeek dayOfWeak = this.startingDay;
        do {
            System.out.printf("%3s ", dayOfWeak.getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("ru")));
            dayOfWeak = dayOfWeak.plus(1);
        } while (dayOfWeak != this.startingDay);
        System.out.println();
    }
}
