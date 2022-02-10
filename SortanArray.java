public class SortanArray {
    // merge sort - time: O(nlogn) space: O(n)
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }
    
    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }
    
    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int index = left; index <= right; index++) {
            nums[index] = temp[index];
        }
    }

    // quick sort - time: O(nlogn) space: O(logn)
    public int[] sortArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int idx = partition(nums, left, right);
        quickSort(nums, left, idx - 1);
        quickSort(nums, idx + 1, right);
    }
    
    private int partition(int[] nums, int left, int right) {
        int val = nums[left];
        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= j && nums[i] <= val) {
                i++;
            }
            while (i <= j && nums[j] > val) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
