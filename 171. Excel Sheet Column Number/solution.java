// 本质就是个26进制的数，找出每一位对应的数就行，我从最低位开始,第二种方法从最高位开始，可以根据上一步的result*26，省去了Math.pow
class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(s.length() - i - 1) - 'A' + 1;
            result += temp * Math.pow(26, i);
        }
        
        return result;
    }
}

class Solution {
    public int titleToNumber(String s) {
     int result = 0;
        for(int i = 0; i < s.length(); i++){
            result = result*26 + (s.charAt(i) -'A'+1);
        }
        return result;
    }
}
