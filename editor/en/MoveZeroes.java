//Given an integer array nums, move all 0's to the end of it while maintaining
//the relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// 
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done?
//
// Related Topics Array Two Pointers 👍 16058 👎 420


package com.shuzijun.leetcode.editor.en;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int slowIndex = 0; slowIndex < nums.length; slowIndex++) {
                if (nums[slowIndex] == 0) {
                    for (int fastIndex = slowIndex + 1; fastIndex < nums.length; fastIndex++) {
                        if (nums[fastIndex] != 0) {
                            nums[slowIndex] = nums[fastIndex];
                            nums[fastIndex] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}