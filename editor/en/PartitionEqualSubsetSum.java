//Given an integer array nums, return true if you can partition the array into
//two subsets such that the sum of the elements in both subsets is equal or false 
//otherwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics Array Dynamic Programming 👍 12647 👎 260


package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 == 1) return false;
            int n = nums.length;
            int[] dp = new int[sum / 2 + 1];
            for (int i = 0; i < n; i++) {
                for (int j = sum / 2; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
                if (dp[sum / 2] == sum / 2) return true;
            }
            return dp[sum / 2] == sum / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}