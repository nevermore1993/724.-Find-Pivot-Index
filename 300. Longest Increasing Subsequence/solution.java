// 开始以为是找最长连续子串，  利用滑动窗口方法，如果当连续子串不增加时，窗口起点移动到当前节点
class Solution {
    public int lengthOfLIS(int[] nums) {
        int count = 1;
        int max = 1;
        int start = 0, end = 1;
        while (end < nums.length) {
            if (nums[end] >= nums[end - 1]) {
                count++;
                end++;
            } else {
                start = end;
                end++;
                count = 1;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}

// dp方法，以当前元素为结尾的子串中最长的子串长度，是其之前子串的长度+1（当前元素大于之前子串的最后一个元素时）或者不变。最后返回dp[]中
// 最大的元素。
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++)
            max = Math.max(max, dp[i]);
        return max;
    }
}
