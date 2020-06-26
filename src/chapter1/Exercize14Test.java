package chapter1;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Exercize14Test {

    @Nested
    class readArray {

        @Test
        void validOneString() {
            test("1 2 3", new ArrayList<>(List.of(new ArrayList<>(List.of(1, 2, 3)))));
        }

        @Test
        void validSeveralStrings() {
            test("1 2 3\n4 5 6\n7 8 9", new ArrayList<>(List.of(
                    new ArrayList<>(List.of(1, 2, 3)),
                    new ArrayList<>(List.of(4, 5, 6)),
                    new ArrayList<>(List.of(7, 8, 9))
            )));
        }

        @Test
        void invalid() {
            try {
                test("a 2 3", new ArrayList<>(List.of(new ArrayList<>(List.of(1, 2, 3)))));
                fail();
            } catch(Exception e) {
            }
        }

        void test(String input, List<List<Integer>> expected) {
            Scanner s = new Scanner(input);
            List<List<Integer>> got = Exercize14.readArray(s);
            assertEquals(expected, got);
        }

    }

    @Nested
    class isSquare {
        @Test
        void valid() {
            List<List<Integer>> input = new ArrayList<>(List.of(
                    new ArrayList<>(List.of(1,2,3)),
                    new ArrayList<>(List.of(1,2,3)),
                    new ArrayList<>(List.of(1,2,3))
            ));
            assertTrue(Exercize14.isSquare(input));
        }

        @Test
        void invalid() {
            List<List<Integer>> input = new ArrayList<>(List.of(
                    new ArrayList<>(List.of(1,2,3)),
                    new ArrayList<>(List.of(1,2,3,4)),
                    new ArrayList<>(List.of(1,2,3))
            ));
            assertFalse(Exercize14.isSquare(input));
        }
    }

    @Nested
    class isMagic {
        @Test
        void valid() {
            assertTrue(Exercize14.isMagic(new ArrayList<>(List.of(
                    new ArrayList<>(List.of(16, 3, 2, 13)),
                    new ArrayList<>(List.of(5, 10, 11, 8)),
                    new ArrayList<>(List.of(9, 6, 7, 12)),
                    new ArrayList<>(List.of(4, 15, 14, 1))
            ))));
        }

        @Test
        void invalid() {
            assertFalse(Exercize14.isMagic(new ArrayList<>(List.of(
                    new ArrayList<>(List.of(16, 3, 2, 14)),
                    new ArrayList<>(List.of(5, 10, 11, 8)),
                    new ArrayList<>(List.of(9, 6, 7, 12)),
                    new ArrayList<>(List.of(4, 15, 14, 1))
            ))));
        }
    }
}