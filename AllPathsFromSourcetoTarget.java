import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    // DAG + dfs
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(0, cur, res, graph);
        return res;
    }
    
    private void dfs(int node, List<Integer> cur, List<List<Integer>> res, int[][] graph) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int nei : graph[node]) {
            cur.add(nei);
            dfs(nei, cur, res, graph);
            cur.remove(cur.size() - 1);
        }
    }
}
