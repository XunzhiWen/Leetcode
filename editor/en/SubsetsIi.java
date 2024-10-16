//Given an integer array nums that may contain duplicates, return all possible
//subsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in 
//any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
// Example 2: 
// Input: nums = [0]
//Output: [[],[0]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics Array Backtracking Bit Manipulation 👍 9927 👎 336


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();
            backtracking(result, comb, nums, 0);

            return result;
        }

        private void backtracking(List<List<Integer>> result, List<Integer> comb, int[] nums, int curr) {
            result.add(new ArrayList<>(comb));
            for (int i = curr; i < nums.length; i++) {
                if (i > curr && nums[i] == nums[i - 1]) {
                    continue;
                }
                comb.add(nums[i]);
                this.backtracking(result, comb, nums, i + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}