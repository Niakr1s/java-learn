package chapter4;

public abstract class Shape {
    protected Point point;

    Shape(Point p) {
        this.point = new Point(p);
    }

    public void move(double x, double y) {
        point.move(x, y);
    }

    public abstract Point getCenter();
}
