public class LongestCommonPrefix {
    // BF - time: O(minLen * strs.length)
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

    public String longestCommonPrefix2(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int left = 0, right = minLen - 1, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (hasCommon(strs, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res == -1 ? "" : strs[0].substring(0, res + 1);
    }
    
    private boolean hasCommon(String[] strs, int index) {
        String prefix = strs[0].substring(0, index + 1);
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
