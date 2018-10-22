// 先确定small，再确定mid，当mid确定时，一旦有比mid更大的值出现，即便最小值是在mid后面，因为mid已经出现，说明在mid之前有了small
// 就说明存在三连。在比mid更大的值出现之前不停的更新small和mid。
// 最关键的是mid，一旦有mid了就能够说明有一个small在mid之前，只需要找到一个比mid大的就行
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= small) {
                small = i;
            } else if (i <= mid) {
                mid = i;
            } else {
                return true;
            }
        }
        return false;
    }
}

// dp方法
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length == 0)
            return false;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                else
                    dp[i] = Math.max(1, dp[i]);
            }
            if (dp[i] >= 3)
                return true;
        }
        return false;
    }
}
