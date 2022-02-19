import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();// <index>
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        int index = 0;
        while (!stack.isEmpty() && index < nums.length) {
            if (nums[stack.peek()] < nums[index]) {
                res[stack.pop()] = nums[index];
            } else {
                index++;
            }
        }
        return res;
    }
}
