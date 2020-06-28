package chapter4;

public class Rectangle extends Shape {
    private double width, height;

    Rectangle(Point topLeft, double w, double h) {
        super(topLeft);
        this.width = w;
        this.height = h;
    }

    @Override
    public Point getCenter() {
        Point topLeft = new Point(this.point);
        topLeft.move(width / 2, height / 2);
        return topLeft;
    }

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }
}
