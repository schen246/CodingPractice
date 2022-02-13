import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        Queue<int[]> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        q.offer(new int[]{start[0], start[1]});
        set.add(start[0] + ":" + start[1]);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] nei : getNeighbors(maze, cur)) {
                if (nei[0] == destination[0] && nei[1] == destination[1]) return true;
                if (set.add(nei[0] + ":" + nei[1])) {
                    q.offer(new int[]{nei[0], nei[1]});
                }
            }
        }
        return false;
    }
    
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private List<int[]> getNeighbors(int[][] maze, int[] cur) {
        List<int[]> res = new ArrayList<>();
        int m = maze.length, n = maze[0].length;
        for (int[] dir : dirs) {
            int x = cur[0] + dir[0];
            int y = cur[1] + dir[1];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            res.add(new int[]{x - dir[0], y - dir[1]});
        }
        return res;
    }
}
