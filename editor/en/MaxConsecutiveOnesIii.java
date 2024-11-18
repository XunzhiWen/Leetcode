//Given a binary array nums and an integer k, return the maximum number of
//consecutive 1's in the array if you can flip at most k 0's. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined. 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] is either 0 or 1. 
// 0 <= k <= nums.length 
// 
//
// Related Topics Array Binary Search Sliding Window Prefix Sum 👍 8897 👎 150


package com.shuzijun.leetcode.editor.en;

public class MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int left = 0, totalLen = 0, curSum = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 1) curSum++;
                if ((right - left + 1) - curSum <= k)
                    totalLen = totalLen > right - left + 1 ? totalLen : right - left + 1;
                else {
                    if (nums[left] == 1) curSum--;
                    left++;
                }
            }
            return totalLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}