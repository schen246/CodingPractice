public class MaximumSubarray {
    // divide and conquer - time: O(n) space: O(n)
    public int maxSubArray(int[] nums) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(nums, nums.length - 1, res);
        return res[0];
    }
    
    private int dfs(int[] nums, int index, int[] res) {
        if (index == 0) {
            res[0] = Math.max(res[0], nums[0]);
            return nums[0];
        }
        int pre = dfs(nums, index - 1, res);
        int cur = Math.max(pre, 0) + nums[index];
        res[0] = Math.max(res[0], cur);
        return cur;
    }

    // dp - time: O(n) space: O(n)
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
