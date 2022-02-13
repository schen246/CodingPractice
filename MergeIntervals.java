import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // sweep line: sort + arr
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                res.add(new int[]{cur[0], cur[1]});
                cur = intervals[i];
            }
        }
        res.add(new int[]{cur[0], cur[1]});
        return res.toArray(new int[res.size()][]);
    }
}
