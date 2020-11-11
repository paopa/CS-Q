package cs.algorithm.medium.sumevengrandparent;

import cs.algorithm.base.node.BinaryTree;


public class Test {
    public static void main(String[] args) {
        Integer[] input = {6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
        Integer output = Solution.sumEvenGrandparent(new BinaryTree(input).value);
        System.out.println("break point");
    }
}
