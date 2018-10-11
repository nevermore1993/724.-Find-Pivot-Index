// 如果计算过程出现了重复的数，说明会无限循环，我一时没想到用 n%10来取每一位，只想到转换成string再取位
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = n;
        while (temp != 1) {
            String s = String.valueOf(temp);
            temp = 0;
            for (int i = 0; i < s.length(); i++) {
                temp += Math.pow((s.charAt(i) - '0'), 2);
            }
            if (set.contains(temp))
                return false;
            else
                set.add(temp);
        }
        return true;
    }
}

// 如果计算中出现了小于10并且不是1或者7的数，说明不是happy number
public class Solution {
    public boolean isHappy(int n) {
        if (n < 10) {
            return n == 1 || n == 7;
        }
        int newsum = 0;
        while (n != 0) {
            int digit = n % 10;
            newsum += digit*digit;
            n /= 10;
        }
        return isHappy(newsum);
    }
}
