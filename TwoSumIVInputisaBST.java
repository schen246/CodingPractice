import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputisaBST {
    // set + inorder traversal - time: O(n) space: O(height + n)
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(k - node.val)) {
                return true;
            }
            set.add(node.val);
            pushLeft(node.right, stack);
        }
        return false;
    }
    
    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
