import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    // min heap - time: O(nlogk) + O(n) space: O(k) + O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));// min heap
        for (int num : map.keySet()) {
            pq.offer(new int[]{num, map.get(num)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (pq.size() > 0) {
            res.add(pq.poll()[0]);
        }
        return res;
    }
}
