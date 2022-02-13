import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KthSmallestElementinaSortedMatrix {
    // pq - time: O(m * n) space: O(m * n)
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            return matrix[a[0]][a[1]] - matrix[b[0]][b[1]];
        });
        Set<Integer> set = new HashSet<>();
        q.offer(new int[]{0, 0});
        set.add(0 * n + 0);
        while (q.size() > 0) {
            int[] cur = q.poll();
            k--;
            if (k == 0) {
                return matrix[cur[0]][cur[1]];
            }
            if (cur[0] + 1 >= 0 && cur[0] + 1 < m && set.add((cur[0] + 1) * n + cur[1])) {
                q.offer(new int[]{cur[0] + 1, cur[1]});
            }
            if (cur[1] + 1 >= 0 && cur[1] + 1 < n && set.add(cur[0] * n + cur[1] + 1)) {
                q.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return -1;
    }
}
