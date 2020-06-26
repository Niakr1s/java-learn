package chapter1;

public class Exercise11 {
    public static void main(String[] args) {
        printUnicode("Hello Привет 今日和");
    }

    static void printUnicode(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.printf("Rune = %c \tunicode = %d\n", c, (int)c);
        }
    }
}
