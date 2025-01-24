//You are given an array prices where prices[i] is the price of a given stock
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you 
//are engaging multiple transactions at the same time. You must sell before buying 
//again.
// 
//
// Example 3: 
//
// 
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics Array Dynamic Programming 👍 9954 👎 203


package com.shuzijun.leetcode.editor.en;

public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[4];
//            dp0为第一次持有股票的最大现金
            dp[0] = -prices[0];
//            dp1为第一次抛售股票的最大现金
            dp[1] = 0;
//            dp2为第二次持有股票的最大现金
            dp[2] = -prices[0];
//            dp3为第二次抛售股票的最大现金
            dp[3] = 0;
            for (int i = 1; i < prices.length; i++) {
//                第一次持有股票时要么本来就持有股票，要么首次购入股票
                dp[0] = Math.max(dp[0], -prices[i]);
//                第一次抛售股票时要么本来就已经抛售股票，要么当日抛售股票
                dp[1] = Math.max(dp[1], dp[0] + prices[i]);
//                第二次持有股票的最大现金一定是基于已经第一次抛售股票的现金再当日购买
                dp[2] = Math.max(dp[2], dp[1] - prices[i]);
                dp[3] = Math.max(dp[3], dp[2] + prices[i]);

            }
//            最终结果一定是第二次抛售股票。即使只需要操作0或1次，可以理解为最后一天当日购入当日抛出。
            return dp[3];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}