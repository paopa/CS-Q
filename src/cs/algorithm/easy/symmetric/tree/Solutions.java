package cs.algorithm.easy.symmetric.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * Easy
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Follow up: Could you solve it both recursively and iteratively?
 */
public abstract class Solutions {

    public abstract boolean isSymmetric(TreeNode root);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            case "2":
                return new Solution2();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * recursive
     * time complexity: O(n)
     * space complexity: O(n)
     */
    private static class Solution1 extends Solutions {

        @Override
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode a, TreeNode b) {
            if (a == null || b == null) {
                return a == b;
            }
            if (a.val != b.val) {
                return false;
            }
            return isMirror(a.left, b.right) && isMirror(a.right, b.left);
        }
    }

    /**
     * iterative
     * time complexity: O(n)
     * space complexity: O(n)
     */
    private static class Solution2 extends Solutions {

        @Override
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>() {{
                add(root.left);
                add(root.right);
            }};
            TreeNode a, b;
            while (!queue.isEmpty()) {
                a = queue.remove();
                b = queue.remove();
                if (a == null && b == null) continue;
                if (a == null || b == null) return false;
                if (a.val != b.val) return false;
                queue.add(a.left);
                queue.add(b.right);
                queue.add(a.right);
                queue.add(b.left);
            }
            return true;
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
                new TestCase(TestCase.case1()),
                new TestCase(TestCase.case2())
        ).forEach(test -> System.out.println(Solutions.factory("2").isSymmetric(test.root)));
    }

    private static class TestCase {

        TreeNode root;

        public TestCase(TreeNode root) {
            this.root = root;
        }

        public static TreeNode case1() {
            return new TreeNode(1,
                    new TreeNode(2,
                            new TreeNode(3),
                            new TreeNode(4)
                    ),
                    new TreeNode(2,
                            new TreeNode(4),
                            new TreeNode(3)
                    )
            );
        }

        public static TreeNode case2() {
            return new TreeNode(1,
                    new TreeNode(2,
                            null,
                            new TreeNode(4)
                    ),
                    new TreeNode(2,
                            null,
                            new TreeNode(3)
                    )
            );
        }
    }
}
