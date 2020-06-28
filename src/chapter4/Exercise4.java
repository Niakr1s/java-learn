package chapter4;

public class Exercise4 {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(20, 20), 10);
        Rectangle rectangle = new Rectangle(new Point(40, 40), 50, 10);
        Shape[] shapes = new Shape[]{
                circle, rectangle
        };
    }
}
