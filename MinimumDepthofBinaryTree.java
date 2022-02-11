import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    // bfs + early return - time: O(n) space: O(n)
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int res = 0;
        while (q.size() > 0) {
            int n = q.size();
            res++;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

    // recursion - time: O(n) space: O(height)
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left != 0 && right != 0) {
            return Math.min(left, right) + 1;
        }
        return left == 0 ? right + 1 : left + 1;
    }
}
