// 5 ms solution;  store reach of each element, traverse cant get beyond reach, if i is greater than length when traverse finished,
// it indicates that one of the elements can reach beyond last element.
class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0, i = 0;
        for(;i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);
        }
        return i >= nums.length;
    }
}

// my 125ms solution, traverse backward, check if nums[i] can be reached by check if the previous non negetive element is greater
// than their steps. if can be reached, return canJump(subArray), if not, return false  I think this ides belong to 
// dynamic programming 
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i - 1] >= length - i)
                return canJump(Arrays.copyOfRange(nums, 0, length - 1));
            else 
                continue;
        }
        
        return false;
    }
}
