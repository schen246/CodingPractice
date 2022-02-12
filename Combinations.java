import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // dfs - time: O(n^k) space: extra O(k)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(n, k, 1, cur, res);
        return res;
    }
    
    private void dfs(int n, int k, int index, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (index > n) return;
        for (int i = index; i <= n; i++) {
            cur.add(i);
            dfs(n, k, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
