package chapter3;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise15 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Employee("Pavel", 100),
                new Employee("anonimous", 20),
                new Employee("same salary", 100),
        };
        Arrays.sort(employees, Comparator.comparing(Employee::measure).thenComparing(Employee::getName, String::compareTo));
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees, Comparator.comparing(Employee::measure, (a, b) -> -a.compareTo(b)).thenComparing(Employee::getName, String::compareTo));
        System.out.println(Arrays.toString(employees));
    }
}
