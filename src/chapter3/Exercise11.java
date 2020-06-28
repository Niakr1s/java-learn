package chapter3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise11 {
    public static void main(String[] args) {
        var subdirs = getSubdirs("c:/");
        System.out.println(Arrays.toString(subdirs));
    }

    public static String[] getSubdirs(String path) {
        File f = new File(path);
        File[] dirs = f.listFiles(File::isDirectory);
        if (dirs == null) {
            return new String[0];
        }
        return Arrays.stream(dirs).map(File::toString).toArray(String[]::new);
    }
}
