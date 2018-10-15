// 利用hashset来判断元素是否已经存在。
For certain test cases with not very large n, the runtime of this method can be slower than Sorting. 
The reason is hash table has some overhead in maintaining its property. One should keep in mind that real world 
performance can be different from what the Big-O notation says. The Big-O notation only tells us that for sufficiently 
large input, one will be faster than the other. Therefore, when n is not sufficiently large, an O(n) algorithm 
can be slower than an O(nlog⁡n) algorithm.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
