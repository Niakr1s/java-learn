package chapter3;

public class Exercise4 {
    public static void main(String[] args) {
        var constantIter = IntSequence.constant(5);
        for (int i = 0; i < 10; i++) {
            System.out.println(constantIter.next());
        }
    }
}
