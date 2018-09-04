// if sum >= 0, reset MAX, continue add next element. if after sum + nums[i] < 0, reset MAX, discard sum and nums[i], because they 
// have no contribution to increase MAX, restart at nums[i + 1].

class Solution {
    public int maxSubArray(int[] nums) {
        int temp = 0;
        if (nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (temp < 0) {
                temp = nums[i];
            } else {
                temp += nums[i];
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
