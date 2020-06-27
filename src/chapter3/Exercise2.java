package chapter3;

public class Exercise2 {
    public static void main(String[] args) {
        Measurable[] employees = new Measurable[]{
                new Employee("Fred", 10),
                new Employee("Pavel", 20)
        };
        Employee largest = (Employee) MeasurableMetrics.largest(employees);
        System.out.println(largest);
    }
}
