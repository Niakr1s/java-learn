package chapter4;

import java.util.Objects;

public class Exercise4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle = new Circle(new Point(20, 20), 10);
        Rectangle rectangle = new Rectangle(new Point(40, 40), 50, 10);
        Shape[] shapes = new Shape[]{
                circle, rectangle
        };
        Circle clonedCircle = circle.clone();
        System.out.println(Objects.equals(circle.getCenter(), clonedCircle.getCenter()));
        clonedCircle.move(20, 20);
        System.out.println(Objects.equals(circle.getCenter(), clonedCircle.getCenter()));
    }
}
