public class ExpressiveWords {
    // two pointers
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isMatch(s, word)) {
                res++;
            }
        }
        return res;
    }
    
    private boolean isMatch(String s, String w) {
        if (s.equals(w)) {
            return true;
        }
        if (s.length() == 0 || w.length() == 0 || s.length() <= w.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < w.length()) {
            char sc = s.charAt(i);
            char wc = w.charAt(j);
            if (sc != wc) {
                return false;
            }
            
            int cnt1 = 0;
            while (i < s.length() && s.charAt(i) == sc) {
                i++;
                cnt1++;
            }
            
            int cnt2 = 0;
            while (j < w.length() && w.charAt(j) == wc) {
                j++;
                cnt2++;
            }
            
            if (cnt1 < cnt2 || (cnt1 > cnt2 && cnt1 < 3)) {
                return false;
            }
        }
        
        return i == s.length() && j == w.length();
    }
}
