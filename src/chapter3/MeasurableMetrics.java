package chapter3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MeasurableMetrics {
    public static double average(Measurable[] list) {
        return sum(list) / list.length;
    }

    public static double sum(Measurable[] list) {
        return Stream.of(list).map(Measurable::measure).reduce(0d, Double::sum);
    }

    public static Measurable largest(Measurable[] arr) {
        return Stream.of(arr).max(Comparator.comparingDouble(Measurable::measure)).orElse(null);
    }
}
