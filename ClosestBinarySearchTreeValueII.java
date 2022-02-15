import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ClosestBinarySearchTreeValueII {
    // sliding window - time: O(n) space: O(height + k)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> dq = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pushLeft(node.right, stack);
            dq.offerFirst(node.val);
            if (dq.size() > k) {
                if (Math.abs(dq.peekLast() - target) < Math.abs(dq.peekFirst() - target)) {
                    dq.pollFirst();
                    break;
                }
                dq.pollLast();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (dq.size() > 0) {
            res.add(dq.pollLast());
        }
        return res;
    }
    
    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
