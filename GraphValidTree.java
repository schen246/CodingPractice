import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // connected + (E + 1 == V)
        if (n != edges.length + 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(); // <source, list of destination>
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(0, map, visited);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void dfs(int node, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        if (map.get(node) != null) {
            for (int nei : map.get(node)) {
                dfs(nei, map, visited);
            }
        }
    }

    public boolean validTree2(int n, int[][] edges) {
        // connected + (E + 1 == V)
        if (n != edges.length + 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(); // <source, list of destination>
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        bfs(0, map, visited);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void bfs(int node, Map<Integer, List<Integer>> map, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (map.get(cur) != null) {
                for (int nei : map.get(cur)) {
                    if (!visited[nei]) {
                        q.offer(nei);
                        visited[nei] = true;
                    }
                }
            }
        }
    }

    public boolean validTree3(int n, int[][] edges) {
        // check cycle + (E + 1 == V)
        if (n != edges.length + 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(); // <source, list of destination>
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i, -1, map, visited)) {
                return false;
            }
        }
        return true;
    }
    
    // dfs to check cycle, reutrn true means there is cycle in current connect component
    private boolean dfs(int node, int prev, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[node]) {
            return true;
        }
        visited[node] = true;
        if (map.get(node) != null) {
            for (int nei : map.get(node)) {
                if (nei != prev) {
                    if (dfs(nei, node, map, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
