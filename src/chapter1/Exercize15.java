package chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercize15 {
    public static void main(String[] args) {
        List<List<Long>> triangle = generatePascalTriangle(15);
        System.out.println(prettyPrintPascalTriangle(triangle));
    }

    static String prettyPrintPascalTriangle(List<List<Long>> triangle) {
        if (triangle.isEmpty()) return "";
        StringBuilder b = new StringBuilder();
        List<Long> lastRow = triangle.get(triangle.size() - 1);
        int maxElementLength = maxStrLength(lastRow);
        String emptyStr = " ".repeat(maxElementLength);
        int maxElements = lastRow.size() * 2 - 1;
        for (List<Long> row : triangle) {
            String[] expandedRow = new String[maxElements];
            Arrays.fill(expandedRow, emptyStr);
            int middleLength = row.size() * 2 - 1;
            for (int i = 0; i < row.size(); i++) {
                int pos = (maxElements - middleLength) / 2 + i * 2;
                String el = row.get(i).toString();
                expandedRow[pos] = fixedLength(el, maxElementLength);
            }
            b.append(String.join(" ", expandedRow));
            b.append("\n");
        }
        return b.toString();
    }

    static String fixedLength(String s, int l) {
        return String.format("%"+l+"s", s);
    }

    static int maxStrLength(List<Long> row) {
        if (row.isEmpty()) {
            return 0;
        }
        int max = row.get(0).toString().length();
        for (Long i : row) {
            int l = i.toString().length();
            if (l > max) max = l;
        }
        return max;
    }

    static List<List<Long>> generatePascalTriangle(int n) {
        List<List<Long>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res.add(new ArrayList<>(List.of(1L)));
                continue;
            }
            int rowSize = i + 1;
            List<Long> row = new ArrayList<>();
            List<Long> prevRow = res.get(i - 1);
            row.add(prevRow.get(0)); // first
            for (int j = 1; j < rowSize - 1; j++) {
                int prevRowIdx = j - 1;
                row.add(prevRow.get(prevRowIdx) + prevRow.get(prevRowIdx + 1));
            }
            row.add(prevRow.get(prevRow.size() - 1)); // last
            res.add(row);
        }
        return res;
    }
}
