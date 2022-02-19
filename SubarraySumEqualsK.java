import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//<sum, freq>
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            if (map.get(sum - k) != null) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
