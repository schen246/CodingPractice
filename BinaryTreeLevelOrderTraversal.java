import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // bfs - time: O(n) space: extra O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (q.size() > 0) {
            int n = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                cur.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(cur);
        }
        return res;
    }
}
