import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Character> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return a - b;// lower alphabetical
            }
            return Integer.compare(map.get(b), map.get(a));// max heap
        });
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char ch = pq.poll();
            int cnt = map.get(ch);
            for (int i = 0; i < cnt; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
