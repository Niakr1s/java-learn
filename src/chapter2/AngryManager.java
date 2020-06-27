package chapter2;

import java.util.Random;

public class AngryManager {
    static final Random generator;

    static {
        generator = new Random();
    }

    public void increaseSalary(Employee e) {
        double by = 10 * generator.nextGaussian();
        e.raiseSalaryByPercent(by);
    }
}