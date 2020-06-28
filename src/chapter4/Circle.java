package chapter4;

public class Circle extends Shape {
    private double radius;

    Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return point;
    }
}
