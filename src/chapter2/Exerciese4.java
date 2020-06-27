package chapter2;

public class Exerciese4{
    public static void main(String[] args) {
        IntHolder i1 = new IntHolder(1);
        IntHolder i2 = new IntHolder(2);
        System.out.printf("before swapping: %s, %s\n", i1, i2);
        swap(i1, i2);
        System.out.printf("after swapping: %s, %s\n", i1, i2);
    }

    static void swap(IntHolder i1, IntHolder i2) {
        int tmp = i1.getValue();
        i1.setValue(i2.getValue());
        i2.setValue(tmp);
    }
}

class IntHolder {
    private int value;

    public IntHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return String.format("%d", this.value);
    }
}