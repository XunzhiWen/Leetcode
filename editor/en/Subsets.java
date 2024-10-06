//Given an integer array nums of unique elements, return all possible subsets (
//the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
//
// Related Topics Array Backtracking Bit Manipulation 👍 17519 👎 284


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();

            for (int k = 0; k <= nums.length; k++) {
                backtracking(result, comb, nums, 0, k);
            }
            return result;
        }

        private void backtracking(List<List<Integer>> result, List<Integer> comb, int[] nums, int curr, int k) {
            if (comb.size() == k) {
                result.add(new ArrayList<>(comb));
                return;
            }
            for (int i = curr; i < nums.length; i++) {
                comb.add(nums[i]);
                this.backtracking(result, comb, nums, i + 1, k);
                comb.remove(comb.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}