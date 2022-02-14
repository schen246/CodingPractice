import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    // dfs + backtracking - time: O(n) space: O(height) extra
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(root, sum, cur, res);
        return res;
    }
    
    private void dfs(TreeNode root, int target, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                List<Integer> temp = new ArrayList<>(cur);
                temp.add(root.val);
                res.add(temp);
            }
            return;
        }
        cur.add(root.val);
        dfs(root.left, target - root.val, cur, res);
        dfs(root.right, target - root.val, cur, res);
        cur.remove(cur.size() - 1);
    }
}
