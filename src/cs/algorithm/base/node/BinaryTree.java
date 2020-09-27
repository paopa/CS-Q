package cs.algorithm.base.node;

public class BinaryTree {

    public TreeNode value;
    private int i = 0;
    private int n = 0;

    public BinaryTree(Integer[] input) {
        TreeNode root = new TreeNode();
        for (Integer nodeValue : input) {
            generateTreeNode(root, nodeValue);
            i++;
        }
        this.value = root;
    }

    private void generateTreeNode(TreeNode root, Integer nodeValue) {
        if (root.val == 0) {
            root.val = nodeValue;
            return;
        }
        i = i / 2;
        n = i % 2;
        if (i == 0 && n == 1){

        }
    }

    private TreeNode generateNode(TreeNode root, Integer nodeValue) {
        if (root == null) {
            root = new TreeNode(nodeValue);
        }

        return root;
    }

}
