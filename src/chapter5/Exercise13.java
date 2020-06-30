package chapter5;

import java.util.Arrays;

public class Exercise13 {
    public static void main(String[] args) {
        int[] values = new int[1000000];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.println(min(values));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static int min(int[] values) {
        if (values.length == 0) return 0;
        int res = values[0];
        for (int v: values) {
            if (v < res) res = v;
        }
        int finalRes = res;
        assert Arrays.stream(values).allMatch(value -> value >= finalRes);
        return res;
    }
}
