public class LowestCommonAncestorofaBinarySearchTree {
    // iteration - time: O(logn) space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        while (root != null) {
            if (root.val < p && root.val < q) {
                root = root.right;
            } else if (root.val > p && root.val > q) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    // recursion - time: O(logn) space: O(height)
    public TreeNode lowestCommonAncestor2(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val < p && root.val < q) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p && root.val > q) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
