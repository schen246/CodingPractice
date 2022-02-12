import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBST {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("#,");
            } else {
                sb.append(cur.val + ",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        if (strs.length == 1 && strs[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < strs.length) {
            TreeNode cur = q.poll();
            if (strs[i].equals("#")) {
                cur.left = null;
            } else {
                TreeNode leftChild = new TreeNode(Integer.valueOf(strs[i]));
                cur.left = leftChild;
                q.offer(leftChild);
            }
            i++;
            if (strs[i].equals("#")) {
                cur.right = null;
            } else {
                TreeNode rightChild = new TreeNode(Integer.valueOf(strs[i]));
                cur.right = rightChild;
                q.offer(rightChild);
            }
            i++;
        }
        return root;
    }
}
