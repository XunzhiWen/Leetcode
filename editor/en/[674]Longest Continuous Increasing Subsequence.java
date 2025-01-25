//Given an unsorted array of integers nums, return the length of the longest
//continuous increasing subsequence (i.e. subarray). The subsequence must be 
//strictly increasing. 
//
// A continuous increasing subsequence is defined by two indices l and r (l < r)
// such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each 
//l <= i < r, nums[i] < nums[i + 1]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,4,7]
//Output: 3
//Explanation: The longest continuous increasing subsequence is [1,3,5] with 
//length 3.
//Even though [1,3,5,7] is an increasing subsequence, it is not continuous as 
//elements 5 and 7 are separated by element
//4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2]
//Output: 1
//Explanation: The longest continuous increasing subsequence is [2] with length 
//1. Note that it must be strictly
//increasing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics Array 👍 2376 👎 183


package com.shuzijun.leetcode.editor.en;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
/*            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
            }
            int result = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) dp[i] = Math.max(dp[i], dp[i - 1] + 1);
                result = Math.max(result, dp[i]);
            }
            return result;*/
//            贪心/压缩状态的DP
            int dp0 = 1, dp1 = 1, result = 1;
            for (int i = 1; i < nums.length; i++) {
                dp1 = nums[i] > nums[i - 1] ? dp0 + 1 : 1;
                dp0 = dp1;
                result = Math.max(dp1, result);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}