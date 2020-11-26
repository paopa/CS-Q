package cs.algorithm.practice.depth.first.search.right;

import cs.algorithm.practice.depth.first.search.BinarySearchTree;
import cs.algorithm.practice.depth.first.search.Node;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Node node = prepare(List.of(5, 2, 1, 4, 3, 6, 7));
        RightDepthFirstSearch rdfs = new RightDepthFirstSearch();

        rdfs.preOrder(node);
        System.out.println();

        rdfs.inOrder(node);
        System.out.println();

        rdfs.postOrder(node);
        System.out.println();
    }

    private static Node prepare(List<Integer> list) {
        return BinarySearchTree.generate(list);
    }
}
