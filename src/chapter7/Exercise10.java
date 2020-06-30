package chapter7;

import java.util.*;

public class Exercise10 {
    public static void main(String[] args) {
        City moscow = new City("Moscow");
        City cheboksary = new City("Cheboksary");
        City zimbabwe = new City("Zimbabwe");
        City london = new City("London");
        cheboksary.addNeighborBi(moscow, 100);
        moscow.addNeighborBi(london, 1000);
        moscow.addNeighborBi(zimbabwe, 500);
        zimbabwe.addNeighborBi(london, 300);
    }
}

class City {
    private final String name;
    private final Set<Neighbor> neighbors = new HashSet<>();

    private Node node = new Node();

    City(String name) {
        this.name = name;
    }

    public void addNeighborBi(City city, int distance) {
        addNeighbor(city, distance);
        city.addNeighbor(this, distance);
    }

    public void addNeighbor(City city, int distance) {
        Neighbor neighbor = new Neighbor(city, distance);
        neighbors.add(neighbor);
    }

    public void compute() {
        cleanNodes();
        Set<City> allCities = getAllCities();
        while (!allCities.stream().allMatch(city -> city.node.isVisited())) {
            Set<City> allCitiesNonVisited = new HashSet<>(allCities);
            allCitiesNonVisited.removeIf(city -> city.node.isVisited());
            if (allCitiesNonVisited.isEmpty()) return;

            City city = Collections.min(allCitiesNonVisited, Comparator.comparing(o -> o.node));

            List<Neighbor> neighbors = new ArrayList<>(city.neighbors);
            neighbors.removeIf(neighbor -> neighbor.getCity().node.isVisited());
            neighbors.sort(Comparator.comparing(neighbor -> neighbor.getCity().node));

            for (Neighbor neighbor : neighbors) {
                City neighborCity = neighbor.getCity();
                double lengthToSet = city.node.getAccumulator() + neighbor.getDistance();
                if (neighborCity.node.isInfinity() || neighborCity.node.getAccumulator() > lengthToSet) {
                    neighborCity.node.set(lengthToSet);
                }
            }
            city.node.setVisited(true);
        }
    }

    private void cleanNodes() {
        for (City c : getAllCities()) {
            c.node = new Node();
        }
        node.set(0);
    }

    public Set<City> getAllCities() {
        Set<City> cities = new HashSet<>();
        getAllCitiesHelper(this, cities);
        return cities;
    }

    private static void getAllCitiesHelper(City city, Set<City> visited) {
        visited.add(city);
        for (Neighbor n : city.neighbors) {
            if (visited.contains(n.getCity())) continue;
            getAllCitiesHelper(n.getCity(), visited);
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }

    public Node getNode() {
        return node;
    }
}

class Node implements Comparable<Node> {
    private double accumulator = Double.POSITIVE_INFINITY;
    private boolean visited = false;

    public void set(double value) {
        accumulator = value;
    }

    public void add(double value) {
        if (isInfinity()) accumulator = 0;
        accumulator += value;
    }

    public boolean isInfinity() {
        return Double.isInfinite(accumulator);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getAccumulator() {
        return accumulator;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(accumulator, o.accumulator);
    }
}

class Neighbor {
    private final int distance;
    private final City city;

    public Neighbor(City city, int distance) {
        this.distance = distance;
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbor neighbor = (Neighbor) o;
        return Objects.equals(city, neighbor.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }
}