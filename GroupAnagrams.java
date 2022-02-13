import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    // map + sort + arr
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String cur = new String(arr);
            map.putIfAbsent(cur, new ArrayList<>());
            map.get(cur).add(str);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
