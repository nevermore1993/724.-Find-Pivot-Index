// my solutin, find every ascend subarray, get its sum
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int total = 0;
        int temp = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min && temp == 0) {
                min = prices[i];
            } else {
                if (temp < prices[i] - min)
                    temp = prices[i] - min;
                else {
                    total += temp;
                    temp = 0;
                    min = Integer.MAX_VALUE;
                    i--;
                }
            }
        }
        total += temp;
        return total;
    }
}

// just add every positive difference
class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        
        for(int i = prices.length - 1; i > 0; i--)
            if(prices[i] - prices[i-1] > 0)
                max_profit += prices[i] - prices[i-1];
        
        return max_profit;
    }
}
