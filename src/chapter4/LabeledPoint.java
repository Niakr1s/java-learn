package chapter4;

public class LabeledPoint extends Point{
    protected String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public LabeledPoint(String label, Point point) {
        this(label, point.x, point.y);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' +
                ", " + super.toString() +
                '}';
    }
}
