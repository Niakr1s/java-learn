package chapter7;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {
    @Test
    void TestComputeTwoCities() {
        City one = new City("one");
        City two = new City("two");
        one.addNeighborBi(two, 9);
        one.compute();
        assertEquals(0, one.getNode().getAccumulator());
        assertEquals(9, two.getNode().getAccumulator());
    }

    @Test
    void TestComputeThreeCities() {
        City one = new City("one");
        City two = new City("two");
        City three = new City("three");
        one.addNeighborBi(two, 9);
        one.addNeighborBi(three, 11);
        one.compute();
        assertEquals(0, one.getNode().getAccumulator());
        assertEquals(9, two.getNode().getAccumulator());
        assertEquals(11, three.getNode().getAccumulator());
    }

    @Test
    void TestComputeThreeAdjacentCities() {
        City one = new City("one");
        City two = new City("two");
        City three = new City("three");
        one.addNeighborBi(two, 9);
        one.addNeighborBi(three, 11);
        two.addNeighborBi(three, 5);
        one.compute();
        assertEquals(0, one.getNode().getAccumulator());
        assertEquals(9, two.getNode().getAccumulator());
        assertEquals(11, three.getNode().getAccumulator());
    }

    @Test
    void TestComputeFour() {
        City one = new City("one");
        City two = new City("two");
        City three = new City("three");
        City four = new City("four");
        one.addNeighborBi(two, 7);
        one.addNeighborBi(three, 9);
        one.addNeighborBi(four, 14);
        two.addNeighborBi(three, 10);
        four.addNeighborBi(three, 2);
        one.compute();
        assertEquals(0, one.getNode().getAccumulator());
        assertEquals(7, two.getNode().getAccumulator());
        assertEquals(9, three.getNode().getAccumulator());
        assertEquals(11, four.getNode().getAccumulator());
    }

    @Test
    void TestCompute6() {
        City one = new City("one");
        City two = new City("two");
        City three = new City("three");
        City four = new City("four");
        City five = new City("five");
        City six = new City("six");
        one.addNeighborBi(two, 7);
        one.addNeighborBi(three, 9);
        one.addNeighborBi(six, 14);
        two.addNeighborBi(three, 10);
        two.addNeighborBi(four, 15);
        three.addNeighborBi(six, 2);
        three.addNeighborBi(four, 11);
        five.addNeighborBi(six, 9);
        five.addNeighborBi(four, 6);
        one.compute();
        assertEquals(0, one.getNode().getAccumulator());
        assertEquals(7, two.getNode().getAccumulator());
        assertEquals(9, three.getNode().getAccumulator());
        assertEquals(20, four.getNode().getAccumulator());
        assertEquals(20, five.getNode().getAccumulator());
        assertEquals(11, six.getNode().getAccumulator());
    }

    @Test
    void ComputeAfterCompute() {
        City one = new City("one");
        City two = new City("two");
        one.addNeighborBi(two, 9);
        one.compute();
        two.compute();
        assertEquals(9, one.getNode().getAccumulator());
        assertEquals(0, two.getNode().getAccumulator());
    }
}