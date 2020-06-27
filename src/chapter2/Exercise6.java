package chapter2;

public class Exercise6 {
    public static void main(String[] args) {
        System.out.println(new MutatedPoint(3, 4).translate(1, 3).scale(0.5));
    }
}

/**
 * MutatedPoint holds x and y coordinates. MutatedPoint is mutable.
 */
class MutatedPoint {
    private double x;
    private double y;

    public MutatedPoint() {
        this(0, 0);
    }

    public MutatedPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public MutatedPoint translate(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public MutatedPoint scale(double factor) {
        this.x *= factor;
        this.y *= factor;
        return this;
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }
}