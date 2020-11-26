package cs.algorithm.practice.depth.first.search.right;

import cs.algorithm.practice.depth.first.search.AbstractDepthFirstSearch;
import cs.algorithm.practice.depth.first.search.Node;

public class RightDepthFirstSearch extends AbstractDepthFirstSearch {

    @Override
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.value + " ");
        preOrder(node.right);
        preOrder(node.left);
    }

    @Override
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.right);
        System.out.print(" " + node.value + " ");
        inOrder(node.left);
    }

    @Override
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.right);
        postOrder(node.left);
        System.out.print(" " + node.value + " ");
    }
}
