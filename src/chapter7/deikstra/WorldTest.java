package chapter7.deikstra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
    private static final String ONE = "one";
    private static final String TWO = "two";
    private static final String THREE = "three";
    private static final String FOUR = "four";
    private static final String FIVE = "five";
    private static final String SIX = "six";

    @Test
    void TestAddNode() {
        World<String> world = new World<>();
        assertTrue(world.add(ONE));
        assertTrue(world.add(TWO));
        assertFalse(world.add(ONE));
        assertEquals(2, world.size());
    }

    @Test
    void TestGetMinimumDistance1() {
        World<String> world = new World<>();
        world.add(ONE);
        world.add(TWO);
        world.setDistanceBi(ONE, TWO, 9);
        assertEquals(9, world.getMinimumDistance(ONE, TWO));
    }


    @Test
    void TestGetMinimumDistanceToItself() {
        World<String> world = new World<>();
        world.add(ONE);
        world.add(TWO);
        world.setDistanceBi(ONE, TWO, 9);
        assertEquals(0, world.getMinimumDistance(ONE, ONE));
    }

    @Test
    void TestGetMinimumDistanceTwice() {
        World<String> world = new World<>();
        world.add(ONE);
        world.add(TWO);
        world.setDistanceBi(ONE, TWO, 9);
        assertEquals(9, world.getMinimumDistance(ONE, TWO));
        assertEquals(9, world.getMinimumDistance(TWO, ONE));
    }

    @Test
    void TestGetMinimumDistanceFor6Nodes() {
        World<String> world = new World<>();

        world.add(ONE);
        world.add(TWO);
        world.add(THREE);
        world.add(FOUR);
        world.add(FIVE);
        world.add(SIX);

        world.setDistanceBi(ONE, TWO, 7);
        world.setDistanceBi(ONE, THREE, 9);
        world.setDistanceBi(ONE, SIX, 14);
        world.setDistanceBi(TWO, THREE, 10);
        world.setDistanceBi(TWO, FOUR, 15);
        world.setDistanceBi(THREE, SIX, 2);
        world.setDistanceBi(THREE, FOUR, 11);
        world.setDistanceBi(FIVE, SIX, 9);
        world.setDistanceBi(FIVE, FOUR, 6);

        assertEquals(0, world.getMinimumDistance(ONE, ONE));
        assertEquals(7, world.getMinimumDistance(ONE, TWO));
        assertEquals(9, world.getMinimumDistance(ONE, THREE));
        assertEquals(20, world.getMinimumDistance(ONE, FOUR));
        assertEquals(20, world.getMinimumDistance(ONE, FIVE));
        assertEquals(11, world.getMinimumDistance(ONE, SIX));

        assertEquals(15, world.getMinimumDistance(TWO, FOUR));
    }
}