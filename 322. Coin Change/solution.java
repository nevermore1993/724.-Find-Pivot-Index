// dp 方法，dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); 从小的开始设置dp，如果从结果往前推，要考虑的情况太多了，会超时，而且也不能叫做
// dp了。
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

//  看起来像是贪心算法，从最大的硬币开始，从总数里去掉最大硬币能组成的部分，对剩下的部分在小一些的硬币里找组合。
class Solution {
    public int coinChange(int[] coins, int amount) {
        return first(coins, amount);
    }

    private int ans;
    public int first(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return amount == 0 ? 1 : -1;
        }
        ans = amount + 1;
        Arrays.sort(coins);
        helper(coins, amount, 0, coins.length-1);
        return ans == amount + 1 ? -1 : ans;
    }


    public void helper(int[] coins, int remain, int numCoins, int idx) {
        int coin = coins[idx];
        if (idx == 0) {
            if (remain % coin == 0) {
                this.ans = Math.min(this.ans, numCoins + remain / coin);
            }
        } else {
            int k = remain / coin;
            while (k >= 0 && numCoins + k < this.ans) {
                /** remain will never be negative */
                helper(coins, remain - k * coin, numCoins+k, idx-1);
                k--;
            }
        }
    }
}
