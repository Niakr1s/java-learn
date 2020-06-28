package chapter4;

public abstract class Shape implements Cloneable{
    protected Point point;

    Shape(Point p) {
        this.point = new Point(p);
    }

    public void move(double x, double y) {
        point.move(x, y);
    }

    public abstract Point getCenter();

    @Override
    protected Shape clone() throws CloneNotSupportedException {
        final Shape cloned =  (Shape) super.clone();
        cloned.point = new Point(cloned.point);
        return cloned;
    }
}
