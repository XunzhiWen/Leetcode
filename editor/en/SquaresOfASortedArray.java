//Given an integer array nums sorted in non-decreasing order, return an array
//of the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, 
//could you find an 
//O(n) solution using a different approach?
//
// Related Topics Array Two Pointers Sorting 👍 8609 👎 214


package com.shuzijun.leetcode.editor.en;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            int left = 0, right = n - 1;
            int i = n - 1;
            while (left <= right) {
                int sqr_left = nums[left] * nums[left];
                int sqr_right = nums[right] * nums[right];
                if (sqr_right < sqr_left) {
                    result[i] = sqr_left;
                    left++;
                    i--;
                } else {
                    result[i] = sqr_right;
                    right--;
                    i--;
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}