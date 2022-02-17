import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointstoOrigin {
    // pq - time: O(nlogk) space: O(k) extra
    public List<List<Integer>> kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]));// max heap
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(cur[0], cur[1])));
        }
        return res;
    }
}
