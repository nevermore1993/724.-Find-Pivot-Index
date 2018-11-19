// 按位取x，逆转成int，比较  但是不能兼容溢出的情况，如果逆转后溢出了就会出错。
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int origin = x;
        int reversed = 0;
        
        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        
        return reversed == origin;
    }
}

//按位取，但是保存每一位，然后遍历比较，可以兼容溢出的情况，因为没有重新生成int
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
