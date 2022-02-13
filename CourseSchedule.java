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

    class Node {
        int val;
        int indegree;
        List<Integer> neighbors;
        public Node(int val) {
            this.val = val;
            this.indegree = 0;
            this.neighbors = new ArrayList<>();
        }
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap<>();// <num, node>
        for (int[] p : prerequisites) {
            map.putIfAbsent(p[1], new Node(p[1]));
            map.putIfAbsent(p[0], new Node(p[0]));
            map.get(p[1]).neighbors.add(p[0]);
            map.get(p[0]).indegree++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int num : map.keySet()) {
            if (map.get(num).indegree == 0) {
                q.offer(num);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (int nei : map.get(cur).neighbors) {
                map.get(nei).indegree--;
                if (map.get(nei).indegree == 0) {
                    q.offer(nei);
                }
            }
        }
        return cnt == map.size();
    }
}
