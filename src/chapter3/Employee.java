package chapter3;

public class Employee implements Measurable {
    private static int nextId = 0;
    private int id;
    private String name;
    private double salary;

    Employee(String name, double salary) {
        this.id = nextId++;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double measure() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
