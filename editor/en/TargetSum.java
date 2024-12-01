/**
 * <p>You are given an integer array <code>nums</code> and an integer <code>target</code>.</p>
 *
 * <p>You want to build an <strong>expression</strong> out of nums by adding one of the symbols <code>'+'</code> and <code>'-'</code> before each integer in nums and then concatenate all the integers.</p>
 *
 * <ul>
 * <li>For example, if <code>nums = [2, 1]</code>, you can add a <code>'+'</code> before <code>2</code> and a <code>'-'</code> before <code>1</code> and concatenate them to build the expression <code>"+2-1"</code>.</li>
 * </ul>
 *
 * <p>Return the number of different <strong>expressions</strong> that you can build, which evaluates to <code>target</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,1,1,1], target = 3
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1], target = 1
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 20</code></li>
 * <li><code>0 &lt;= nums[i] &lt;= 1000</code></li>
 * <li><code>0 &lt;= sum(nums[i]) &lt;= 1000</code></li>
 * <li><code>-1000 &lt;= target &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Dynamic Programming</li><li>Backtracking</li></div></div><br><div><li>👍 11117</li><li>👎 371</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            return BackTracking(nums, 0, target, 0, new HashMap<>());
        }

        private int BackTracking(int[] nums, int curr, int target, int idx, HashMap<String, Integer> hashMap) {
            if (idx == nums.length) {
                return curr == target ? 1 : 0;
            }
            String key = idx + "." + curr;
            if (hashMap.containsKey(key)) return hashMap.get(key);
            int add = BackTracking(nums, curr + nums[idx], target, idx + 1, hashMap);
            int minus = BackTracking(nums, curr - nums[idx], target, idx + 1, hashMap);
            hashMap.put(key, add + minus);
            return add + minus;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}