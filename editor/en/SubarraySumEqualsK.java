//Given an array of integers nums and an integer k, return the total number of
//subarrays whose sum equals to k. 
//
// A subarray is a contiguous non-empty sequence of elements within an array. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// 
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics Array Hash Table Prefix Sum 👍 22174 👎 694


package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int sum = 0, total = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, 1);
            for (int num : nums) {
                sum += num;
                if (hashMap.containsKey(sum - k)) {
                    total += hashMap.get(sum - k);
                }
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
            return total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}