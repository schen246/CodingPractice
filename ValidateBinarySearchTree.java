import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree {
    // M1: recursion - time: O(n) space: O(height)
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean valid(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }

    // M2: iteration - time: O(n) space: O(n)
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            pushLeft(cur.right, stack);
            if (!stack.isEmpty() && cur.val >= stack.peek().val) {
                return false;
            }
            
        }
        return true;
    }
    
    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
