import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (left < right && !set.contains(arr[left])) {
                left++;
            }
            while (left < right && !set.contains(arr[right])) {
                right--;
            }
            if (left >= right) break;
            swap(arr, left++, right--);
        }
        return new String(arr);
    }
    
    private void swap(char[] arr, int i, int j) {
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}
