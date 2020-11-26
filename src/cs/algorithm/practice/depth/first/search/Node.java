package cs.algorithm.practice.depth.first.search;

public class Node {
    public Node left;
    public Node right;
    public Integer value;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }
}
