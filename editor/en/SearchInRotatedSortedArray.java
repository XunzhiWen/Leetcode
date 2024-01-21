//There is an integer array nums sorted in ascending order (with distinct
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// 
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics Array Binary Search 👍 25244 👎 1494


package com.shuzijun.leetcode.editor.en;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums = new int[]{5, 1, 3};
        solution.search(nums, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] > nums[n - 1]) {
//                    Pivot is at right part of array
                    left = mid + 1;
                } else {
//                    Pivot is at left part of array
                    right = mid - 1;
                }
            }
//            1st method: 2 binary searches
            int l = binany(nums, target, 0, left - 1);
            if (l != -1) {
                return l;
            } else {
                return binany(nums, target, left, n - 1);
            }
        }

        public int binany(int[] nums, int target, int left, int right) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}