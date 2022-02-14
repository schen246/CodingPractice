public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int[] res = new int[1];
        dfs(nums, S, 0, res);
        return res[0];
    }
    
    private void dfs(int[] nums, int target, int index, int[] res) {
        if (index == nums.length) {
            if (target == 0) {
                res[0]++;
            }
            return;
        }
        // pos
        dfs(nums, target - nums[index], index + 1, res);
        // neg
        dfs(nums, target + nums[index], index + 1, res);
    }
}
