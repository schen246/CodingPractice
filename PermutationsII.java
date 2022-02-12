import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    // dfs - time: O(n!) space: O(n^2) = O(n + n - 1 + n - 2 + ... + 1)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num : nums) cur.add(num);
            res.add(cur);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, i, index);
                dfs(nums, index + 1, res);
                swap(nums, i, index);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
