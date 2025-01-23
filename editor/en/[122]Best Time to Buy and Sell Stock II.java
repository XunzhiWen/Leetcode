/**
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the iᵗʰ day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at
 * most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-
 * 1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-
 * 1 = 4.
 * Total profit is 4.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the
 * stock to achieve the maximum profit of 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= prices.length <= 3 * 10⁴
 * 0 <= prices[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics Array Dynamic Programming Greedy 👍 14154 👎 2744
 */

package com.shuzijun.leetcode.editor.en;

public class BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[2];
            dp[0] = -prices[0];
            dp[1] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[0] = Math.max(dp[0], dp[1] - prices[i]);
                dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            }
            return dp[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}