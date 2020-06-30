package chapter7;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise7 {
    public static void main(String[] args) {
        Reader reader = new StringReader("a b b a c");
        System.out.println(count(reader));
    }

    public static Map<String, Integer> count(Reader reader) {
        Scanner in = new Scanner(reader);
        Map<String, Integer> res = new TreeMap<>();
        while (in.hasNext()) {
            String word = in.next();
            res.merge(word, 1, (a, b) -> ++a);
        }
        return res;
    }
}
