package chapter2;

import java.util.LinkedList;

public class Exercise16 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push("first");
        System.out.printf("size after push = %d\n", q.size());
        q.pop();
        System.out.printf("size after pop from non-empty = %d\n", q.size());
        q.pop();
        System.out.printf("size after pop from empty = %d\n", q.size());
    }
}

class Queue {
    static private class Node {
        private final String value;

        Node(String v) {
            this.value = v;
        }
    }

    private final LinkedList<Node> nodes = new LinkedList<>();

    public void push(String v) {
        nodes.push(new Node(v));
    }

    public String pop() {
        if (nodes.isEmpty()) {
            return null;
        }
        return nodes.pop().value;
    }

    public int size() {
        return nodes.size();
    }
}