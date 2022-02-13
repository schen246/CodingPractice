public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i-1]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
