package chapter2;

public class Exercise9 {
    public static void main(String[] args) {
        Car car = new Car(5);
        System.out.println(car);
        car.move(20);
        System.out.println(car);
        car.fillFuel(50);
        System.out.println(car);
        car.move(5);
        System.out.println(car);
        car.move(20);
        System.out.println(car);
    }
}

/**
 * Car represents a car, moving along with x-axis.
 */
class Car {
    /**
     * Remained amount of fuel. Can not be negative.
     */
    private double fuelRemained = 0;

    /**
     * How much fuel spends by moving 1 of distance. Can not be negative.
     */
    private final double fuelEfficiency;

    /**
     * Traveled distance.
     */
    private double distance = 0;

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void fillFuel(double amount) {
        this.fuelRemained += amount;
    }

    public void move(double distance) {
        if (distance < 0 ) {
            return;
        }
        distance = Math.min(distance, distanceFuelRemained());
        this.fuelRemained -= fuelForDistance(distance);
        this.distance += distance;
    }

    private double fuelForDistance(double distance) {
        return distance * this.fuelEfficiency;
    }

    private double distanceFuelRemained() {
        if (this.fuelEfficiency <= 0) {
            return 0;
        }
        return this.fuelRemained / this.fuelEfficiency;
    }

    public String toString() {
        return String.format("Car at distance %.2f with fuel remained = %.2f", this.distance, this.fuelRemained);
    }
}