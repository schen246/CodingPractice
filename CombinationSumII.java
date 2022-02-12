import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    // dfs - time: O(n^height) space: O(height)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur, res);
        return res;
    }
    
    private void dfs(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> res) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
