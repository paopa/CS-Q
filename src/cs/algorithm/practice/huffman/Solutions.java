package cs.algorithm.practice.huffman;

import cs.algorithm.base.Console;

import java.util.*;

public abstract class Solutions implements Console<String> {

    enum Type {
        V1(new Solution1());

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
        return createTree(input).toString();
    }

    public abstract Node createTree(String text);

    private static class Solution1 extends Solutions {
        @Override
        public Node createTree(String text) {
            final Map<Character, Node> map = toMap(text);
            final LinkedList<Node> queue = new LinkedList<>(new ArrayList<>(map.values()));
            Node root = null;
            while (!queue.isEmpty()) {
                if (queue.size() == 1) {
                    root = queue.poll();
                    break;
                }
                Collections.sort(queue);
                Node node1 = queue.poll();
                Node node2 = queue.poll();
                queue.push(new Node((node1.getValue() + node2.getValue()), node1, node2));
            }
            return root;
        }

        private Map<Character, Node> toMap(String text) {
            return new HashMap<>() {{
                for (char c : text.toCharArray()) {
                    if (this.containsKey(c)) {
                        this.get(c).increase();
                        continue;
                    }
                    this.put(c, new Node(c));
                }
            }};
        }
    }
}

class Verifier {
    public static void main(String[] args) {
        Console.execute(Solutions.factory(Solutions.Type.V1));
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
