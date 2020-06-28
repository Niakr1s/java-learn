package chapter3;

public class Exercise14 {
    public static void main(String[] args) {
        Runnable[] runnables = new Runnable[]{
                new Greeter(3, "Pavel"),
                new Greeter(4, "Anna"),
        };
        Runnable merged = toRunnable(runnables);
        new Thread(merged).start();
    }

    public static Runnable toRunnable(Runnable[] runnables) {
        return () -> {
            for (var r : runnables) {
                r.run();
            }
        };
    }
}
