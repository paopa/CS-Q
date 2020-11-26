package cs.algorithm.practice.depth.first.search.left;

import cs.algorithm.practice.depth.first.search.AbstractDepthFirstSearch;
import cs.algorithm.practice.depth.first.search.Node;

public class LeftDepthFirstSearch extends AbstractDepthFirstSearch {

    @Override
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(" " + node.value + " ");
        inOrder(node.right);
    }

    @Override
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(" " + node.value + " ");
    }
}
