package chapter3;

import java.util.Random;

public class Greeter implements Runnable {
    private static Random gen = new Random();
    private final int times;
    private final String name;

    Greeter(int times, String name) {
        this.times = times;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.printf("Hello, %s\n", name);
            try {
                Thread.sleep(gen.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
