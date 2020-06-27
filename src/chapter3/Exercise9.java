package chapter3;

public class Exercise9 {
    public static void main(String[] args) {
        new Thread(new Greeter(10, "Pavel")).start();
        new Thread(new Greeter(5, "Anonimous")).start();
    }
}
