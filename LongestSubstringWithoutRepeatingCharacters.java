import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, res = 0;
        while (j < s.length()) {
            char cj = s.charAt(j++);
            while (set.contains(cj)) {
                char ci = s.charAt(i++);
                set.remove(ci);
            }
            set.add(cj);
            res = Math.max(res, set.size());
        }
        return res;
    }
}
