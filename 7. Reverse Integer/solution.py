# 数字转换为字符列表，倒序生成新的字符列表，再根据符号生成倒序数字，并判断是否大于intmax或小于intmin
class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        sign = [1,-1][x < 0]
        rst = sign * int(str(abs(x))[::-1])
        return rst if -(2**31)-1 < rst < 2**31 else 0
        
        
class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        b = 2 ** 31
        neg_b = -1 * b
        result = 0
        if x > 0:
            while x > 0:
                result = x % 10 + result * 10
                x = x // 10
        else:
            x = abs(x)
            while x > 0:
                result = x % 10 + result * 10
                x = x // 10
            result *= -1
        
        if result >= b or result < neg_b:
            return 0
        return result
