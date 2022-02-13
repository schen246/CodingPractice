public class AddStrings {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() -1, n2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while (n1 >= 0 || n2 >= 0 || rem != 0) {
            if (n1 >= 0) {
                rem += num1.charAt(n1) - '0';
                n1--;
            }
            if (n2 >= 0) {
                rem += num2.charAt(n2) - '0';
                n2--;
            }
            sb.append(rem % 10);
            rem /= 10;
        }
        return sb.reverse().toString();
    }
}
