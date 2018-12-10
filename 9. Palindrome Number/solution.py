# 切片，x[::-1]倒序生成新列表，跟原列表比较
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if(x >= 0):
            return str(x) == str(x)[::-1]
        else:
            return False

# 将数字逆过来，跟原数字比较
class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        r = 0
        temp = x
        if x < 0:
            return False
        while temp > 0:
            r = r * 10 + temp % 10
            temp //= 10
        if r == x:
            return True
        else:
            return False
