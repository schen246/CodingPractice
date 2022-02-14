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

    // recursion top-down - time: O(n) space: O(height)
    public boolean isValidBST3(TreeNode root) {
        return helper(root)[0] == 1;
    }
    
    private long[] helper(TreeNode root) {
        if (root == null) {
            return new long[]{1, Long.MAX_VALUE, Long.MIN_VALUE}; // isBST, min, max
        }
        long[] left = helper(root.left);
        long[] right = helper(root.right);
        long[] ans = new long[3];
        if (left[0] == 1 && right[0] == 1 && left[2] < root.val && root.val < right[1]) {
            ans[0] = 1;
            ans[1] = Math.min(left[1], root.val);
            ans[2] = Math.max(right[2], root.val);
        } else {
            ans[0] = -1;
        }
        return ans;
    }

    // recursion + wrapper class
    public boolean isValidBST4(TreeNode root) {
        Node res = helper2(root);
        return res.isBST;
    }
    
    private Node helper2(TreeNode root) {
        if (root == null) {
            return new Node(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }
        Node left = helper2(root.left);
        Node right = helper2(root.right);
        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            return new Node(true, Math.min(left.min, root.val), Math.max(root.val, right.max));
        }
        return new Node(false, 0, 0);
    }

    class Node {
        boolean isBST;
        long min, max;
        public Node(boolean isBST, long min, long max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
