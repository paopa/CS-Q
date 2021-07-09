package cs.algorithm.practice.huffman;

import cs.algorithm.base.Console;

import java.util.*;

public abstract class Solutions implements Console<String> {

    enum Type {
        A(new Solution1());

        private final Solutions solution;

        Type(Solutions solution) {
            this.solution = solution;
        }
    }

    public static Solutions factory(Type type) {
        return type.solution;
    }

    @Override
    public String execute(String input) {
        return encode(input);
    }

    public abstract String encode(String text);

    private static class Solution1 extends Solutions {
        @Override
        public String encode(String text) {
            final Map<String, Node> map = new HashMap<>();
            for (char c : text.toCharArray()) {
                final String s = String.valueOf(c);
                if (map.containsKey(s)) {
                    map.get(s).increase();
                } else {
                    map.put(s, new Node(c));
                }
            }
            final LinkedList<Node> queue = new LinkedList<>(new ArrayList<>(map.values()));
            Collections.sort(queue);
            Node root = null;
            while (!queue.isEmpty()) {
                if (queue.size() == 1) {
                    root = queue.poll();
                    break;
                }
                Node node1 = queue.poll();
                Node node2 = queue.poll();
                queue.push(new Node((node1.getValue() + node2.getValue()), node1, node2));
                Collections.sort(queue);
            }
            return root.toString();
        }
    }
}

class Verifier {
    public static void main(String[] args) {
        Console.execute(Solutions.factory(Solutions.Type.A));
    }
}

class Node implements Comparable<Node> {
    private char key;
    private int value;
    private Node left;
    private Node right;

    public Node(char key) {
        this.key = key;
        value++;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public char getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void increase() {
        this.value++;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", value=" + value + ", " +
                "left=" + left + ", right=" + right + "}";
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.getValue(), o.getValue());
    }
}
