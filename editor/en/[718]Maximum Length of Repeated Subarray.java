//Given two integer arrays nums1 and nums2, return the maximum length of a
//subarray that appears in both arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
//Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics Array Binary Search Dynamic Programming Sliding Window 
//Rolling Hash Hash Function 👍 6901 👎 175


package com.shuzijun.leetcode.editor.en;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
/*            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int result = 0;
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
//                    dp[i][j]为nums1[i-1]结尾数组和nums2[j-1]结尾数组最大相同子序列长度
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        result = Math.max(dp[i][j], result);
                    }
                }
            }
            return result;*/
//        滚动数组，降低空间复杂度
            int[] dp = new int[nums2.length + 1];
            int res = 0;
            for (int i = 1; i <= nums1.length; i++) {
//                注意滚动数组内层循环必须从后向前以防止状态覆盖
                for (int j = nums2.length; j >= 1; j--) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
//                        这一步置零在二维DP初始化时被隐式地完成了，但是滚动数组方法必须显式写出
                        dp[j] = 0;
                    }
                    res = Math.max(res, dp[j]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}