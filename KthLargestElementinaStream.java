import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementinaStream {
    int k;
    Queue<Integer> pq;

    public KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
