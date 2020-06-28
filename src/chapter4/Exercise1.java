package chapter4;

import java.util.Objects;

public class Exercise1 {
    public static void main(String[] args) {
        Point point = new Point(10, 20);
        LabeledPoint labeledPoint = new LabeledPoint("MyLabel", point);
        System.out.println(point);
        System.out.println(labeledPoint);
    }
}
