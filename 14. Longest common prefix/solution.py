'''
zip(*strs) : 星号用来将列表分离成一个个元素，zip()将所有可遍历参数对应的位置的元素组合成元组。如zip([1,2],[2,3],[3,4]) = (1,2,3),(2,3,4)
长度由最短的元素的长度决定. enumerate()将一个可遍历的数据对象(如列表、元组或字符串)组合为一个索引序列。enumerate（zip([1,2],[2,3],[3,4])）=
0 (1, 2, 3)
1 (2, 3, 4)
这里就将每个单词的相同位置的字母取出组成元组，然后set()来判断是否是相同的
'''
class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""
            
        for i, letter_group in enumerate(zip(*strs)):
            if len(set(letter_group)) > 1:
                return strs[0][:i]
        else:
            return min(strs)
