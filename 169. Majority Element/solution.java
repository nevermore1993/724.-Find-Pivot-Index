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


// 也可以使用递归调用，maj返回剩余数组中的主要元素。当我们的count==0时，说明已经遍历过的数组中没有元素出现次数超过一半，去掉这部分数组
// 对结果没有影响。
class Solution {
    public int majorityElement(int[] nums) {
        return maj(nums, 0, nums[0]);
    }
    private int maj(int[] nums, int start, int cur) {
        int count = 1;
        for (int i = start; i < nums.length; i++) {
            if (cur == nums[i]) count++;
            else count--;
            if (count == 0) return maj(nums, i+1,nums[i]);
        }
        return cur;
    }
}
