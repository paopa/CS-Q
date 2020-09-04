package cs.algorithm.base.binaryTree;

public class BinarySearchTree {

    public TreeNode value;

    public BinarySearchTree(Integer[] input) {
        TreeNode root = new TreeNode();
        for (Integer nodeValue : input) {
            if (nodeValue == null) continue;
            generateTreeNode(root, nodeValue);
        }
        this.value = root;
    }

    private static void generateTreeNode(TreeNode root, Integer nodeValue) {
        if (root.val == 0) {
            root.val = nodeValue;
        } else if (root.val > nodeValue) {
            root.left = generateNode(root.left, nodeValue);
        } else if (root.val < nodeValue) {
            root.right = generateNode(root.right, nodeValue);
        }
    }

    private static TreeNode generateNode(TreeNode root, Integer nodeValue) {
        if (root == null) {
            root = new TreeNode(nodeValue);
        } else {
            generateTreeNode(root, nodeValue);
        }
        return root;
    }
}
