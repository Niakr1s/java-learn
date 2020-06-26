package chapter1;

public class Excersize5 {
    public static void main(String[] args) {
        double largeDouble = (double) Integer.MAX_VALUE + 20000;
        int cast = (int) largeDouble;
        System.out.printf("maximum int value = %d, largeDouble = %f, casted = %d\n", Integer.MAX_VALUE, largeDouble, cast);
        System.out.print("As you see, cast == Integer.MAX_VALUE\n");
        cast++;
        System.out.printf("Incremented cast = %d\n", cast);
    }
}
