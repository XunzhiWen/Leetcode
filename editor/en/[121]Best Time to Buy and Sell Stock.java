/**
 * You are given an array prices where prices[i] is the price of a given stock on
 * the iᵗʰ day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and
 * choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot
 * achieve any profit, return 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-
 * 1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must
 * buy before you sell.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= prices.length <= 10⁵
 * 0 <= prices[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics Array Dynamic Programming 👍 32331 👎 1236
 */

package com.shuzijun.leetcode.editor.en;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int[] dp = new int[2];
//        dp[0] denotes holding the stock
//        dp[1] denotes not holding the stock
            dp[0] = -prices[0];
            dp[1] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[0] = Math.max(dp[0], -prices[i]);
                dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            }
            return dp[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}