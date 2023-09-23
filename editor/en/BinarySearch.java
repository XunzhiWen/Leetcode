//Given an array of integers nums which is sorted in ascending order, and an
//integer target, write a function to search target in nums. If target exists, then 
//return its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ < nums[i], target < 10⁴ 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
//
// Related Topics Array Binary Search 👍 10796 👎 216


package com.shuzijun.leetcode.editor.en;

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* Basic implementation of binary sort
         * Note: no need to use recursion because this uses much more memory than
         * plain loop */
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length;
            return halfSearch(nums, target, left, right);
        }

        public int halfSearch(int[] nums, int target, int left, int right) {

            if (left >= right) {
                return -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                return halfSearch(nums, target, left, mid - 1);
            } else if (nums[mid] < target) {
                return halfSearch(nums, target, mid + 1, right);
            } else {
                return mid;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}