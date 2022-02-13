public class MinimumSizeSubarraySum {
    // sliding window - [i,...,j] keep sum < target
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
