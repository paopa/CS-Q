package cs.algorithm.easy.same.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 100. Same Tree
 * Easy
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * <p>
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * <p>
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */
public abstract class Solutions {

    public abstract boolean isSameTree(TreeNode p, TreeNode q);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        @Override
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left && right;
        }
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Test {

    public static void main(String[] args) {
        List.of(
                new TestCase(TestCase.case1(), TestCase.case1()),
                new TestCase(TestCase.case2A(), TestCase.case2B()),
                new TestCase(TestCase.case3A(), TestCase.case3B())
        ).forEach(test -> System.out.println(Solutions.factory("1").isSameTree(test.p, test.q)));
    }

    private static class TestCase {
        TreeNode p;
        TreeNode q;

        public TestCase(TreeNode p, TreeNode q) {
            this.p = p;
            this.q = q;
        }

        public static TreeNode case1() {
            return new TreeNode(1,
                    new TreeNode(2),
                    new TreeNode(3)
            );
        }

        public static TreeNode case2A() {
            return new TreeNode(1, new TreeNode(2), null);
        }

        public static TreeNode case2B() {
            return new TreeNode(1, null, new TreeNode(2));
        }

        public static TreeNode case3A() {
            return new TreeNode(1, new TreeNode(2), new TreeNode(1));
        }

        public static TreeNode case3B() {
            return new TreeNode(1, new TreeNode(1), new TreeNode(2));
        }
    }
}
