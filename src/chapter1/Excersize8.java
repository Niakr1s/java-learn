package chapter1;

import java.util.ArrayList;
import java.util.List;

public class Excersize8 {
    public static void main(String[] args) {
        printSubstrings("");
        printSubstrings("c");
        printSubstrings("ca");
        printSubstrings("cat");
        printSubstrings("motorbike");
    }

    static void printSubstrings(String str) {
        System.out.println(String.join(",", substrings(str)));
    }

    static List<String> substrings(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.isEmpty()) {
            return res;
        }
        for (int i = 0; i < str.length(); ++i) {
            for (int j = i + 1; j <= str.length(); ++j) {
                res.add(str.substring(i, j));
            }
        }
        return res;
    }
}
