import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, res);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() > 1) {
            res.add(new ArrayList<>(cur));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i]) {
                set.add(nums[i]);
                cur.add(nums[i]);
                dfs(nums, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
