import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofClosedIslands {
    // dfs - time: O(m * n) space: O(m * n)
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    
    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean res = true;
        for (int[] dir : dirs) {
            res &= dfs(grid, i + dir[0], j + dir[1]);
        }
        return res;
    }

    // bfs - time: O(m * n) space: O(m * n)
    public int closedIsland2(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (bfs(grid, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
    
    private boolean bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        grid[i][j] = 1;
        boolean res = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    if (grid[x][y] == 0) {
                        q.offer(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                } else {
                    res = false;
                }
            }
        }
        return res;
    }
}
