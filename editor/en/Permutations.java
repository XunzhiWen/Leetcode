//Given an array nums of distinct integers, return all the possible
//permutations. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// 
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
//
// Related Topics Array Backtracking 👍 19328 👎 337


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();

            backtracking(result, comb, nums, 0);
            return result;
        }

        private void backtracking(List<List<Integer>> result, List<Integer> comb, int[] nums, int curr) {
            if (comb.size() == nums.length) {
                result.add(new ArrayList<>(comb));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!comb.contains(nums[i])) {
                    comb.add(nums[i]);
                    this.backtracking(result, comb, nums, i + 1);
                    comb.remove(comb.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}