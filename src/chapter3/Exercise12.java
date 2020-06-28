package chapter3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Exercise12 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFiles("c:/", (dir, name) -> name.length() < 5)));
    }

    public static String[] getFiles(String path, FilenameFilter filter) {
        File dir = new File(path);
        return dir.list(filter);
    }
}
