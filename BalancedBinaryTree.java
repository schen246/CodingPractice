public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        Node res = helper(root);
        return res.isBalanced;
    }
    
    private Node helper(TreeNode root) {
        if (root == null) {
            return new Node(true, 0);
        }
        Node left = helper(root.left);
        Node right = helper(root.right);
        if (left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1) {
            return new Node(true, Math.max(left.height, right.height) + 1);
        }
        return new Node(false, 0);
    }

    class Node {
        boolean isBalanced;
        int height;
        public Node(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
