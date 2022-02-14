import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class JumpGame {
    // M1: dfs - time: O(n!) space: O(n)
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
    
    private boolean dfs(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }
        for (int i = index + 1; i <= Math.min(index + nums[index], nums.length - 1); i++) {
            if (dfs(nums, i)) {
                return true;
            }
        }
        return false;
    }

    // M2-1: dfs + map memo - time: O(n) space: O(n)
    public boolean canJump21(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(nums.length - 1, true);
        return dfs(nums, 0, map);
    }
    
    private boolean dfs(int[] nums, int index, Map<Integer, Boolean> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        for (int i = index + 1; i <= Math.min(index + nums[index], nums.length - 1); i++) {
            if (dfs(nums, i, map)) {
                map.put(index, true);
                return true;
            }
        }
        map.put(index, false);
        return false;
    }

    // M2-2: dfs + arr memo - time: O(n) space: O(n)
    public boolean canJump22(int[] nums) {
        int[] visited = new int[nums.length];
        visited[nums.length - 1] = 1;
        return dfs(nums, 0, visited);
    }
    
    private boolean dfs(int[] nums, int index, int[] visited) {
        if (visited[index] != 0) {
            return visited[index] == 1;
        }
        for (int i = index + 1; i <= Math.min(index + nums[index], nums.length - 1); i++) {
            if (dfs(nums, i, visited)) {
                visited[index] = 1;
                return true;
            }
        }
        visited[index] = -1;
        return false;
    }

    // M3: bfs + visited - time: O(n) space: O(n)
    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = cur + nums[cur]; i >= cur; i--) {
                if (i >= nums.length - 1) {
                    return true;
                }
                if (!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    // M4: greedy - time: O(n) space: O(1)
    public boolean canJump4(int[] nums) {
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= pos) {
                pos = i;
            }
        }
        return pos == 0;
    }

    // M5: dp - time: O(n^2) space: O(n)
    public boolean canJump5(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(n - 1, i + nums[i]); j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
