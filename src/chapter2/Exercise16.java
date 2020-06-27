package chapter2;

import java.util.LinkedList;

public class Exercise16 {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push("first");
        q.push("second");
        Queue.Iterator iter = q.iterator();
        for (int i = 0; iter.hasNext(); i++) {
            System.out.println(i + " " + iter.next());
        }
    }
}

class Queue {
    static private class Node {
        private final String value;

        Node(String v) {
            this.value = v;
        }
    }

    public class Iterator {
        private int nextIdx = 0;

        public boolean hasNext() {
            if (nodes.isEmpty()) {
                return false;
            }
            return nextIdx < nodes.size();
        }

        public String next() {
            return nodes.get(this.nextIdx++).value;
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

    public Iterator iterator() {
        return new Iterator();
    }
}