import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    // dfs - time: O(n^k) space: O(k)
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(k, n, 1, cur, res);
        return res;
    }
    
    private void dfs(int k, int target, int index, List<Integer> cur, List<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0 && cur.size() == k) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            cur.add(i);
            dfs(k, target - i, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
