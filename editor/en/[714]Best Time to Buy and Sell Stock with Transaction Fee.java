//You are given an array prices where prices[i] is the price of a given stock
//on the iᵗʰ day, and an integer fee representing a transaction fee. 
//
// Find the maximum profit you can achieve. You may complete as many 
//transactions as you like, but you need to pay the transaction fee for each transaction. 
//
// Note: 
//
// 
// You may not engage in multiple transactions simultaneously (i.e., you must 
//sell the stock before you buy again). 
// The transaction fee is only charged once for each stock purchase and sale. 
// 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,3,2,8,4,9], fee = 2
//Output: 8
//Explanation: The maximum profit can be achieved by:
//- Buying at prices[0] = 1
//- Selling at prices[3] = 8
//- Buying at prices[4] = 4
//- Selling at prices[5] = 9
//The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
// 
//
// Example 2: 
//
// 
//Input: prices = [1,3,7,5,10,3], fee = 3
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 7308 👎 219


package com.shuzijun.leetcode.editor.en;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int dp0 = -prices[0], dp1 = 0;
            for (int i = 1; i < prices.length; i++) {
                dp0 = Math.max(dp0, dp1 - prices[i]);
                dp1 = Math.max(dp1, dp0 + prices[i] - fee);
            }
            return dp1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}