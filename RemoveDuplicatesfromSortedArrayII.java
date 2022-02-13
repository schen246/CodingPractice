public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 2, j = 2;
        while (j < nums.length) {
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
