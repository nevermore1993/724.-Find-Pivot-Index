// recursion method, form string of n from string of n - 1
class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        
        String s = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int length = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++)  {
            if (c == s.charAt(i)) {
                length += 1;
            } else {
                result.append(String.valueOf(length) + c);
                length = 1;
                c = s.charAt(i);
            }
        }
        result.append(String.valueOf(length) + c);
        return result.toString();
    }
}
