package cs.algorithm.practice.depth.first.search;

import java.util.List;

import static java.util.Objects.isNull;

public class BinarySearchTree {

    public static Node generate(List<Integer> list) {
        Node node = new Node();
        list.forEach(element -> traversal(node, element));
        return node;
    }

    private static void traversal(Node node, Integer element) {

        if (isNull(node.value)) {
            node.value = element;
            return;
        }

        if (node.value > element) {
            if (node.left == null) {
                node.left = new Node(element);
                return;
            }
            traversal(node.left, element);
            return;
        }

        if (node.value < element) {
            if (node.right == null) {
                node.right = new Node(element);
                return;
            }
            traversal(node.right, element);
        }
    }
}
