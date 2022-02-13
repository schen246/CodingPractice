import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {
    // sliding window - time: O(s.length() + p.length()) space: O(26)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int cnt = map.size();
        int i = 0, j = 0;
        while (j < s.length()) {
            // add j
            char cj = s.charAt(j);
            if (map.containsKey(cj)) {
                int cur = map.get(cj);
                if (cur == 1) {
                    cnt--;
                }
                map.put(cj, cur - 1);
            }
            // add res
            if (cnt == 0) {
                res.add(i);
            }
            // remove i
            if (j - i + 1 == p.length()) {
                char ci = s.charAt(i);
                if (map.containsKey(ci)) {
                    int cur = map.get(ci);
                    if (cur == 0) {
                        cnt++;
                    }
                    map.put(ci, cur + 1);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
