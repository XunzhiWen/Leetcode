//Given an integer array nums, return the length of the longest strictly
//increasing subsequence. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
//complexity? 
//
// Related Topics Array Binary Search Dynamic Programming 👍 21457 👎 469


package com.shuzijun.leetcode.editor.en;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
            }
//            dp[i]指以nums[i]结尾的最长增子序列长度
            int result = 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}