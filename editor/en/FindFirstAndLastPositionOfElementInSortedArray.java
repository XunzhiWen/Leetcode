//Given an array of integers nums sorted in non-decreasing order, find the
//starting and ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// 
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// 
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums is a non-decreasing array. 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics Array Binary Search 👍 19838 👎 481


package com.shuzijun.leetcode.editor.en;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int first = BinarySearchBound(nums, target, true);
            if (first == -1) {
                return new int[]{-1, -1};
            } else {
                return new int[]{first, BinarySearchBound(nums, target, false)};
            }
        }

        public int BinarySearchBound(int[] nums, int target, boolean isFirst) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (isFirst) {
                        if (mid == left || nums[mid - 1] != target) {
                            return mid;
                        } else {
                            right = mid - 1;
                        }
                    } else {
                        if (mid == right || nums[mid + 1] != target) {
                            return mid;
                        } else {
                            left = mid + 1;
                        }
                    }
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}