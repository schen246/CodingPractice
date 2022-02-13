import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }
    
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        grid[i][j] = 0;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                    q.offer(new int[]{x, y});
                    grid[x][y] = 0;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
