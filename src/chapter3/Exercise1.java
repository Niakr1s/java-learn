package chapter3;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        Measurable[] employees = new Measurable[]{
                new Employee("Fred", 10),
                new Employee("Pavel", 20)
        };
        System.out.println(MeasurableMetrics.average(employees) + ", " + MeasurableMetrics.sum(employees));
    }
}
