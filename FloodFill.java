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
}
