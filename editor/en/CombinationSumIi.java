//Given a collection of candidate numbers (candidates) and a target number (
//target), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics Array Backtracking 👍 11107 👎 324


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();
            Arrays.sort(candidates);
            backtracking(result, comb, candidates, target, 0);
            return result;
        }

        private void backtracking(List<List<Integer>> result, List<Integer> comb, int[] candidates, int remain, int curr) {
            if (remain == 0) {
                result.add(new ArrayList<>(comb));
                return;
            } else if (remain < 0) {
                return;
            }

            for (int i = curr; i < candidates.length; i++) {
//                The step below is the key to prevent duplicates
                if (i > curr && candidates[i] == candidates[i - 1]) continue;
                comb.add(candidates[i]);
                this.backtracking(result, comb, candidates, remain - candidates[i], i + 1);
                comb.remove(comb.size() - 1);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}