import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofProvincesFriendCircle {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, isConnected);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(int node, boolean[] visited, int[][] matrix) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1) {
                dfs(i, visited, matrix);
            }
        }
    }

    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length, res = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, isConnected);
                res++;
            }
        }
        return res;
    }
    
    private void bfs(int node, boolean[] visited, int[][] matrix) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < matrix[cur].length; i++) {
                if (matrix[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
