//Find all valid combinations of k numbers that sum up to n such that the
//following conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain 
//the same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics Array Backtracking 👍 6094 👎 114


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> comb = new LinkedList<>();

            backtracking(k, n, comb, result);

            return result;

        }

        private void backtracking(int num, int remaining, List<Integer> comb, List<List<Integer>> result) {
            if (remaining == 0) {
//                Need to create a deep copy
                result.add(new ArrayList<>(comb));
                return;
            } else if (remaining < 0) {
                return;
            }

            for (int i = 1; i < 10; i++) {
                if (!comb.contains(i)) {
                    comb.add(i);
                    this.backtracking(num - 1, remaining - i, comb, result);
                    comb.remove(comb.size() - 1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}