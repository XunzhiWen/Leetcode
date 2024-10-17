//Given a collection of numbers, nums, that might contain duplicates, return
//all possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics Array Backtracking 👍 8603 👎 147


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();
            List<Integer> index = new ArrayList<>();

            backtracking(result, comb, index, nums);
            return result;
        }

        private void backtracking(List<List<Integer>> result, List<Integer> comb, List<Integer> index, int[] nums) {
            if (comb.size() == nums.length) {
                result.add(new ArrayList<>(comb));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!index.contains(i)) {
                    comb.add(nums[i]);
                    index.add(i);
                    this.backtracking(result, comb, index, nums);
                    comb.remove(comb.size() - 1);
                    index.remove(index.size() - 1);

                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}