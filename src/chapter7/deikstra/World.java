package chapter7.deikstra;

import java.util.*;

/**
 * World represents collection of T and distances between them.
 * Implements Deikstra alghorithm.
 */
public class World<T> {
    private final Map<T, Node<T>> nodes = new HashMap<>();
    /**
     * Represents last T, for which was computed distance.
     */
    private T lastFrom;

    /**
     * Adds item into world.
     *
     * @return true if succesfully added, false if such item already exists.
     */
    public boolean add(T item) {
        if (nodes.get(item) != null) return false;
        nodes.put(item, new Node<>());
        return true;
    }

    /**
     * Sets distance from item1 to item2 and same for item2 to item1.
     */
    public void setDistanceBi(T item1, T item2, double distance) {
        setDistanceTo(item1, item2, distance);
        setDistanceTo(item2, item1, distance);
    }

    /**
     * Sets distance from item1 to item2.
     */
    public void setDistanceTo(T item1, T item2, double distance) {
        Node<T> node1 = nodes.get(item1);
        Node<T> node2 = nodes.get(item2);
        if (node1 == null || node2 == null) return;

        node1.addNeighbor(node2, distance);
    }

    /**
     * Gets minimum distance between from and to.
     *
     * @return infinity if (from or to doesn't exists) or if from and to doesn't connected
     */
    public double getMinimumDistance(T from, T to) {
        Node<T> nodeFrom = nodes.get(from);
        Node<T> nodeTo = nodes.get(to);
        if (nodeFrom == null || nodeTo == null) return Double.POSITIVE_INFINITY;

        if (!Objects.equals(nodeFrom, lastFrom)) {
            resetNodes();
            nodeFrom.compute();
            lastFrom = from;
        }

        return nodeTo.getDistanceAccumulator();
    }

    /**
     * Helper function, resets all nodes to default values.
     */
    private void resetNodes() {
        for (Node<T> node : nodes.values()) {
            node.reset();
        }
    }

    public int size() {
        return nodes.size();
    }
}

class Node<T> implements Comparable<Node<T>> {
    private double distanceAccumulator;
    private boolean visited;

    Node() {
        reset();
    }

    private final Set<Neighbor<T>> neighbors = new HashSet<>();

    /**
     * Sets distanceAccumulator and visited to default values.
     */
    public void reset() {
        distanceAccumulator = Double.POSITIVE_INFINITY;
        visited = false;
    }

    /**
     * Recalculates all connected node distances for this node. All nodes must be cleaned before.
     */
    public void compute() {
        // Setting distanceAccumulator for start node to zero, according to Deikstra alghorithm.
        this.distanceAccumulator = 0;

        Set<Node<T>> allConnectedNodes = getAllConnectedNodes();
        while (true) {
            Node<T> node = getMinimalNonVisitedFrom(allConnectedNodes);
            if (node == null) return;

            // getting all non-visited neighbors
            List<Neighbor<T>> nonVisitedNeighbors = new ArrayList<>(node.neighbors);
            nonVisitedNeighbors.removeIf(neighbor -> neighbor.getNode().isVisited());
            nonVisitedNeighbors.sort(Comparator.comparing(Neighbor::getNode));

            for (Neighbor<T> neighbor : nonVisitedNeighbors) {
                Node<T> neighborNode = neighbor.getNode();
                double distanceToSet = node.distanceAccumulator + neighbor.getDistance();
                if (neighborNode.isInfinity() || neighborNode.distanceAccumulator > distanceToSet) {
                    neighborNode.distanceAccumulator = distanceToSet;
                }
            }
            node.setVisited();
        }
    }

    private Node<T> getMinimalNonVisitedFrom (Set<Node<T>> nodes) {
        Set<Node<T>> nonVisitedNodes = new HashSet<>(nodes);
        nonVisitedNodes.removeIf(Node::isVisited);
        if (nonVisitedNodes.isEmpty()) return null;

        return Collections.min(nonVisitedNodes);
    }

    private Set<Node<T>> getAllConnectedNodes() {
        Set<Node<T>> nodes = new HashSet<>();
        getAllConnectedNodesForNode(this, nodes);
        return nodes;
    }

    private void getAllConnectedNodesForNode(Node<T> node, Set<Node<T>> visited) {
        visited.add(node);
        for (Neighbor<T> n : node.neighbors) {
            if (visited.contains(n.getNode())) continue;
            getAllConnectedNodesForNode(n.getNode(), visited);
        }
    }

    public void addNeighbor(Node<T> item, double distance) {
        Neighbor<T> neighbor = new Neighbor<>(item, distance);
        neighbors.add(neighbor);
    }

    private boolean isInfinity() {
        return Double.isInfinite(distanceAccumulator);
    }

    private boolean isVisited() {
        return visited;
    }

    private void setVisited() {
        this.visited = true;
    }

    public double getDistanceAccumulator() {
        return distanceAccumulator;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(distanceAccumulator, o.distanceAccumulator);
    }
}

class Neighbor<T> {
    private final double distance;
    private final Node<T> node;

    public Neighbor(Node<T> node, double distance) {
        this.distance = distance;
        this.node = node;
    }

    public Node<T> getNode() {
        return node;
    }

    public double getDistance() {
        return distance;
    }
}