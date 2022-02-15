import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    // bfs
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int res = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            res = q.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }

    // dfs
    public int findBottomLeftValue2(TreeNode root) {
        int[] res = new int[2];
        dfs(root, 1, res);
        return res[1];
    }
    
    private void dfs(TreeNode root, int level, int[] res) {
        if (root == null) {
            return;
        }
        if (level > res[0]) {
            res[0] = level;
            res[1] = root.val;
        }
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }
}
