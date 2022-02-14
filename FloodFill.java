import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    // dfs + inplace dedup - time: O(m * n) space: O(m * n)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != color) {
            return;
        }
        image[r][c] = newColor;
        for (int[] dir : dirs) {
            dfs(image, r + dir[0], c + dir[1], color, newColor);
        }
    }

    // bfs - time: O(m * n) space: O(m * n)
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == color) {
                    q.offer(new int[]{x, y});
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }
}
