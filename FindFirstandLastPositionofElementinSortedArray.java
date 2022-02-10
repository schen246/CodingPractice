public class FindFirstandLastPositionofElementinSortedArray {
    // time: O(logn) space: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = bsFirst(nums, target);
        res[1] = bsLast(nums, target);
        return res;
    }
    
    private int bsFirst(int[] nums, int target) {
        int i = 0, j = nums.length - 1, res = -1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                res = m;
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return res;
    }
    
    private int bsLast(int[] nums, int target) {
        int i = 0, j = nums.length - 1, res = -1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                res = m;
                i = m + 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return res;
    }
}
