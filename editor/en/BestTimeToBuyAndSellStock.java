/**
 * <p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>
 *
 * <p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>
 *
 * <p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> prices = [7,1,5,3,6,4]
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> prices = [7,6,4,3,1]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Dynamic Programming</li></div></div><br><div><li>👍 23966</li><li>👎 748</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            /*This Question is not about finding maximum or minimum in this array, it's about
             * find the max difference between elements. */
            int min = Integer.MAX_VALUE;
            int overall_profit = 0;
            int present_profit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                present_profit = prices[i] - min;
                if (present_profit > overall_profit) {
                    overall_profit = present_profit;
                }

            }
            return overall_profit;

        }
    }


//leetcode submit region end(Prohibit modification and deletion)
}
