import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NumberofIslands {
    // bfs + inplace dedup - time: O(m * n) space: O(min(m, n))
    // dfs + inplace dedup - time: O(m * n) space: O(m * n)
    public int numIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);// dfs
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int[] dir : DIRS) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }

    private void dfs2(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                dfs2(grid, x, y);
            }
        }
    }
    
    private void bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        grid[i][j] = 0;
        int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : DIRS) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                    q.offer(new int[]{x, y});
                    grid[x][y] = 0;
                }
            }
        }
    }

    // bfs + set dedup - time: O(m * n) space: O(m * n)
    public int numIslands2(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && set.add(i * m + j)) {
                    bfs(grid, i, j, set);
                    res++;
                }
            }
        }
        return res;
    }
    
    private final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private void bfs(int[][] grid, int i, int j, Set<Integer> set) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : DIRS) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 && set.add(x * grid.length + y)) {
                    q.offer(new int[]{x, y});
                }
            }
        }
    }

    public int numIslands3(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !set.contains(i * m + j)) {
                    dfs(grid, i, j, set);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, Set<Integer> set) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        if (!set.add(i * grid.length + j)) {
            return;
        }
        for (int[] dir : DIRS) {
            dfs(grid, i + dir[0], j + dir[1], set);
        }
    }
}
