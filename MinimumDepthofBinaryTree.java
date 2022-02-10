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
}
