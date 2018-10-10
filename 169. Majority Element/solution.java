// 从第一个元素开始，记为temp，count为1，遍历。如果不等于temp，count--，如果等于temp，count++.当count为0时说明已经遍历的子数组中，temp出现的次数
// 与其他所有元素出现的次数相同，即一半，则可以不考虑这部分数组了，因为这部分数组中出现次数最多的元素是temp，而其他的元素即使在后面会出现更多次，也不会
// 影响最后的计数。更新temp，遍历剩余的数组。在一定存在majority element的前提下，遍历结束时候的temp一定是majority element。如果不能保证一定存在，
// 则需要二次遍历来保证temp一定是结果。
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int temp = nums[0];
        if (nums.length == 1)
            return temp;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                temp = nums[i];
                count++;
                continue;
            }
            if (nums[i] == temp)
                count++;
            else {
                count--;
            }
        }
        return temp;
    }
}
