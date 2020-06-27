package chapter3;

import java.util.Iterator;

public class Exercise6 {
    public static void main(String[] args) {
        var bigIntSquareIter = new SquareSentence();
        for (int i = 0; i < 100000 && bigIntSquareIter.hasNext(); i++) {
            bigIntSquareIter.next();
        }
        System.out.println(bigIntSquareIter.next());
    }
}
