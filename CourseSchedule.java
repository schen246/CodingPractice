import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    // topological sort - time: O(E + E + V) space: O(E + V + V + V)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();// <source, List of destination>
        int[] indegree = new int[numCourses];
        // build graph
        for (int[] p : prerequisites) {
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        // topological sort
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            if (map.containsKey(cur)) {
                for (int nei : map.get(cur)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        return cnt == indegree.length;
    }
}
