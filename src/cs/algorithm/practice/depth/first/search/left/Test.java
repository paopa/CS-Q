package cs.algorithm.practice.depth.first.search.left;

import cs.algorithm.practice.depth.first.search.BinarySearchTree;
import cs.algorithm.practice.depth.first.search.Node;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Node node = prepare(List.of(5, 2, 1, 4, 3, 6, 7));
        LeftDepthFirstSearch ldfs = new LeftDepthFirstSearch();

        ldfs.preOrder(node);
        System.out.println();

        ldfs.inOrder(node);
        System.out.println();

        ldfs.postOrder(node);
        System.out.println();
    }

    private static Node prepare(List<Integer> integers) {
        return BinarySearchTree.generate(integers);
    }

}
