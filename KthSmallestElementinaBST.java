import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestElementinaBST {
    // iteration inorder - time: O(height + k) space: O(height)
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            pushLeft(cur.right, stack);
        }
        return -1;
    }
    
    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
