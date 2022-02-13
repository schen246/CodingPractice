import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1) {
            return -1;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int distance = 1;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y > 0 && y < n && grid[x][y] == 0) {
                        if (x == m - 1 && y == n - 1) {
                            return distance;
                        }
                        q.offer(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
