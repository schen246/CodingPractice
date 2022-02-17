import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NumberofConnectedComponentsinanUndirectedGraph {
    // dfs - time: O(V + E) space: O(V + E)
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, map);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(int node, boolean[] visited, Map<Integer, List<Integer>> map) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        if (map.get(node) != null) {
            for (int nei : map.get(node)) {
                dfs(nei, visited, map);
            }
        }
    }

    // bfs - time: O(V + E) space: O(V + E)
    public int countComponents2(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, map);
                res++;
            }
        }
        return res;
    }

    private void bfs(int node, boolean[] visited, Map<Integer, List<Integer>> map) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map.containsKey(cur)) {
                for (int nei : map.get(cur)) {
                    if (!visited[nei]) {
                        q.offer(nei);
                        visited[nei] = true;
                    }
                }
            }
        }
    }
}
