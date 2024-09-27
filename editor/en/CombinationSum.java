/**
 * <p>Given an array of <strong>distinct</strong> integers <code>candidates</code> and a target integer <code>target</code>, return <em>a list of all <strong>unique combinations</strong> of </em><code>candidates</code><em> where the chosen numbers sum to </em><code>target</code><em>.</em> You may return the combinations in <strong>any order</strong>.</p>
 *
 * <p>The <strong>same</strong> number may be chosen from <code>candidates</code> an <strong>unlimited number of times</strong>. Two combinations are unique if the <span data-keyword="frequency-array">frequency</span> of at least one of the chosen numbers is different.</p>
 *
 * <p>The test cases are generated such that the number of unique combinations that sum up to <code>target</code> is less than <code>150</code> combinations for the given input.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [2,3,6,7], target = 7
 * <strong>Output:</strong> [[2,2,3],[7]]
 * <strong>Explanation:</strong>
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [2,3,5], target = 8
 * <strong>Output:</strong> [[2,2,2,2],[2,3,3],[3,5]]
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> candidates = [2], target = 1
 * <strong>Output:</strong> []
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= candidates.length &lt;= 30</code></li>
 * <li><code>2 &lt;= candidates[i] &lt;= 40</code></li>
 * <li>All elements of <code>candidates</code> are <strong>distinct</strong>.</li>
 * <li><code>1 &lt;= target &lt;= 40</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Backtracking</li></div></div><br><div><li>👍 18517</li><li>👎 406</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> comb = new ArrayList<>();

            backtrack(result, comb, target, 0, candidates);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> comb, int remain, int start, int[] candidates) {
            if (remain==0){
                result.add(new ArrayList<>(comb));
                return;
            }
            else if (remain<0){
                return;
            }
            for (int i = start; i <candidates.length; i++) {
                comb.add(candidates[i]);
                this.backtrack(result, comb, remain-candidates[i], i, candidates);
                comb.remove(comb.size()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}