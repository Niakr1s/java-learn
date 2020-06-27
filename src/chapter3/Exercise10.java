package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class Exercise10 {
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>(List.of(
                new Greeter(3, "pavel"),
                new Greeter(5, "evgeniy"),
                new Greeter(8, "maria")
        ));
        runOneByOne(tasks.toArray(new Runnable[0]));
        System.out.println("-------------");
    }

    public static void runTogether(Runnable... tasks) {
        for (var task : tasks) {
            new Thread(task).start();
        }
    }

    public static void runOneByOne(Runnable... tasks) {
        for (var task : tasks) {
            task.run();
        }
    }
}
