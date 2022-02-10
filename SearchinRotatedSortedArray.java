public class SearchinRotatedSortedArray {
    // time: O(logn) space: O(1)
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (target >= nums[i]) {
                if (nums[i] <= nums[m] && nums[m] < target) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            } else {
                if (target < nums[m] && nums[m] <= nums[j]) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
        }
        return -1;
    }
}
