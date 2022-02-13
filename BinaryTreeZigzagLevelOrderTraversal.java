import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                cur.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            if (level % 2 == 0) {
                res.add(cur);
            } else {
                Collections.reverse(cur);
                res.add(cur);
            }
            level++;
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> cur = new ArrayList<>();
            if (level % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.pollFirst();
                    cur.add(node.val);
                    if (node.left != null) q.offerLast(node.left);
                    if (node.right != null) q.offerLast(node.right);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.pollLast();
                    cur.add(node.val);
                    if (node.right != null) q.offerFirst(node.right);
                    if (node.left != null) q.offerFirst(node.left);
                }
            }
            res.add(cur);
            level++;
        }
        return res;
    }
}
