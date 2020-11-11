package cs.algorithm.medium.bsttogst;

import cs.algorithm.base.node.BinarySearchTree;
import cs.algorithm.base.node.TreeNode;

public class Test {
    public static void main(String[] args) {
        Integer[] input = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode greatSumTree = Solution.bstToGst(new BinarySearchTree(input).value);
        System.out.println("break point");
    }
}
