import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // backtracking - time: O(2^n) space: O(n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, res);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // not add 
        dfs(nums, index + 1, cur, res);
        // add
        cur.add(nums[index]);
        dfs(nums, index + 1, cur, res);
        cur.remove(cur.size() - 1);
    }
}
