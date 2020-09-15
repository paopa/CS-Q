package cs.algorithm.medium.sumEvenGrandparent;

import cs.algorithm.base.binaryTree.BinaryTree;
import cs.algorithm.base.binaryTree.TreeNode;


public class Test {
    public static void main(String[] args) {
        Integer[] input = {6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
        Integer output = Solution.sumEvenGrandparent(new BinaryTree(input).value);
        System.out.println("break point");
    }
}
