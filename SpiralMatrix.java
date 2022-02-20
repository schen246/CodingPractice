import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // recursion
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        dfs(matrix, 0, matrix.length, matrix[0].length, res);
        return res;
    }
    
    private void dfs(int[][] matrix, int index, int height, int width, List<Integer> res) {
        if (height <= 1) {
            if (height == 1) {
                for (int i = 0; i < width; i++) {
                    res.add(matrix[index][index + i]);
                }
            }
            return;
        }
        
        if (width <= 1) {
            if (width == 1) {
                for (int i = 0; i < height; i++) {
                    res.add(matrix[index + i][index]);
                }
            }
            return;
        }
        
        for (int i = 0; i < width - 1; i++) {
            res.add(matrix[index][index + i]);
        }
        for (int i = 0; i < height - 1; i++) {
            res.add(matrix[index + i][index + width - 1]);
        }
        for (int i = width - 1; i > 0; i--) {
            res.add(matrix[index + height - 1][index + i]);
        }
        for (int i = height - 1; i > 0; i--) {
            res.add(matrix[index + i][index]);
        }
        
        dfs(matrix, index + 1, height - 2, width - 2, res);
    }
}
