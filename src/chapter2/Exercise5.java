package chapter2;

public class Exercise5 {
    public static void main(String[] args) {
        System.out.println(new Point(3,4).translate(1, 3).scale(0.5));
    }
}

class Point {
    private final double x;
    private final double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point translate(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }

    public Point scale(double factor) {
        return new Point(this.x * factor, this.y * factor);
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", this.x, this.y);
    }
}