import java.util.ArrayDeque;
import java.util.Deque;

public class InorderSuccessorinBST {
    // iteration inorder - time: O(n) space: O(height)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val > p.val) {
                return cur;
            }
            pushLeft(cur.right, stack);
        }
        return null;
    }
    
    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    // binary search - time: O(logn) space: O(height)
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor2(root.right, p);
        } else {
            TreeNode node = inorderSuccessor2(root.left, p);
            if (node == null) {
                return root;
            }
            return node;
        }
    }
}
