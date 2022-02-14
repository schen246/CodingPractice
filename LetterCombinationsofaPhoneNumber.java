import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    Map<Character, List<Character>> map = new HashMap<>();
    {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }
    
    // dfs - time: O(4^n) space: O(n)
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits, sb, 0, res);
        return res;
    }
    
    private void dfs(String digits, StringBuilder sb, int index, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        for (char ch : map.get(digit)) {
            sb.append(ch);
            dfs(digits, sb, index + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
