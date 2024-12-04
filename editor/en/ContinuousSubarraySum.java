//Given an integer array nums and an integer k, return true if nums has a good
//subarray or false otherwise. 
//
// A good subarray is a subarray where: 
//
// 
// its length is at least two, and 
// the sum of the elements of the subarray is a multiple of k. 
// 
//
// Note that: 
//
// 
// A subarray is a contiguous part of the array. 
// An integer x is a multiple of k if there exists an integer n such that x = n 
//* k. 0 is always a multiple of k. 
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [23,2,4,6,7], k = 6
//Output: true
//Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up 
//to 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [23,2,6,4,7], k = 6
//Output: true
//Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose 
//elements sum up to 42.
//42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
// 
//
// Example 3: 
//
// 
//Input: nums = [23,2,6,4,7], k = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= sum(nums[i]) <= 2³¹ - 1 
// 1 <= k <= 2³¹ - 1 
// 
//
// Related Topics Array Hash Table Math Prefix Sum 👍 6413 👎 670


package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        Solution solution = new ContinuousSubarraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int prefixMod = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, -1); // Set the first index to -1 to meet the required distance (2)
            for (int i = 0; i < nums.length; i++) {
                prefixMod = (prefixMod + nums[i]) % k;
                if (hashMap.containsKey(prefixMod) && i - hashMap.get(prefixMod) >= 2) return true;
                hashMap.putIfAbsent(prefixMod, i);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}