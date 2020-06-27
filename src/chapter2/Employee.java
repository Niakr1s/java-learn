package chapter2;

/**
 * @author Niakr1s
 * @version 1.1
 */
public class Employee {
    static private int lastId = 0;
    private final String name;
    private double salary;
    private final int id;

    public Employee(String name, double salary) {
        this.id = lastId++;
        this.salary = salary;
        this.name = name;
    }

    public Employee(double salary) {
        this("", salary);
    }

    public void raiseSalary(double by) {
        this.salary += by;
    }

    /**
     * <img src="doc-files/blue_circle.png"/>
     * @see chapter2.AngryManager
     * @param percent is value <em>between</em> -100.0 and 100.0
     */
    public void raiseSalaryByPercent(double percent) {
        this.salary *= (100d + percent) / 100;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        String employeeString = this.name.isEmpty() ? "Anonimous" : this.name;
        return String.format("%d: %s with salary %.2f$", this.id, employeeString, this.salary);
    }
}
