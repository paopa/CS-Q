package cs.algorithm.medium.bsttogst;

import cs.algorithm.base.node.TreeNode;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * <p>
 * Given the root of a binary search tree with distinct values,
 * modify it so that every node has a new value equal to the sum of the values of the original tree
 * that are greater than or equal to node.val.
 * <p>
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is between 1 and 100.
 * Each node will have value between 0 and 100.
 * The given tree is a binary search tree.
 * <p>
 * Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class Solution {
    public static TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        return travel(root, new int[]{0});
    }

    private static TreeNode travel(TreeNode root, int[] temp) {
        if (root.right != null) {
            travel(root.right, temp);
        }

        root.val += temp[0];
        temp[0] = root.val;

        if (root.left != null) {
            travel(root.left, temp);
        }
        return root;
    }
}
