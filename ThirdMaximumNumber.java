import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                pq.offer(num);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }
        if (pq.size() == 3) {
            return pq.peek();
        }
        while (pq.size() > 1) {
            pq.poll();
        }
        return pq.peek();
    }
}
