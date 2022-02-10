import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinanArray {
    // quick select - time: O(n) average space: O(1)
    public int findKthLargest(int[] nums, int k) {
	    return quickSelect(nums, 0, nums.length - 1, k - 1);
	}
	
	private int quickSelect(int[] nums, int i, int j, int k) {
	    while (i <= j) {
	        int idx = partition(nums, i, j);
	        if (idx == k) {
	            return nums[idx];
	        } else if (idx < k) {
	            i = idx + 1;
	        } else {
	            j = idx - 1;
	        }
	    }
	    return -1;
	}
	
	private int partition(int[] nums, int i, int j) {
	    int val = nums[i], left = i + 1, right = j;
	    while (left <= right) {
	        while (left <= right && nums[left] > val) {
	            left++;
	        }
	        while (left <= right && nums[right] <= val) {
	            right--;
	        }
	        if (left > right) {
	            break;
	        }
	        swap(nums, left, right);
	    }
	    swap(nums, i, right);
	    return right;
	}
	
	private void swap(int[] nums, int i, int j) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}

    // min heap - time: O(nlogk) space: O(k)
    public int findKthLargest2(int[] nums, int k) {
	    Queue<Integer> pq = new PriorityQueue<>();
	    for (int num : nums) {
	        pq.offer(num);
	        if (pq.size() > k) pq.poll();
	    }
	    return pq.peek();
	}
}
