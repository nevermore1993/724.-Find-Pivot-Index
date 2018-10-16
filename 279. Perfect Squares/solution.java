// dp解法， dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
// 这一类求最大最小值，并且结果跟子问题的结果有关的很多都可以用动态规划来求解
class Solution {
    public int numSquares(int n) {
	    int[] dp = new int[n + 1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;
	    for(int i = 1; i <= n; ++i) {
		    int min = Integer.MAX_VALUE;
		    int j = 1;
		    while(i - j*j >= 0) {
			    min = Math.min(min, dp[i - j*j] + 1);
			    ++j;
		    }
		    dp[i] = min;
	    }		
	    return dp[n];
    }
}
