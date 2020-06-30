package chapter7;

import java.io.Reader;
import java.io.StringReader;
import java.util.*;

public class Exercise8 {
    public static void main(String[] args) {
        System.out.println(wordLines(new StringReader("a b c\nd e a\na e a")));
    }

    public static Map<String, Set<Integer>> wordLines(Reader reader) {
        Scanner in = new Scanner(reader);
        Map<String, Set<Integer>> res = new TreeMap<>();
        int lineNo = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] words = line.split("\\s+");
            for (String w : words) {
                res.merge(w, new TreeSet<>(List.of(lineNo)), (integers, integers2) -> {
                    integers.addAll(integers2);
                    return integers;
                });
            }
            lineNo++;
        }
        return res;
    }
}
