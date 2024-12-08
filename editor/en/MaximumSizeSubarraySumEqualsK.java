/**
 * <p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the maximum length of a </em><span data-keyword="subarray"><em>subarray</em></span><em> that sums to</em> <code>k</code>. If there is not one, return <code>0</code> instead.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,-1,5,-2,3], k = 3
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [-2,-1,2,1], k = 1
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The subarray [-1, 2] sums to 1 and is the longest.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>9</sup>&nbsp;&lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>Prefix Sum</li></div></div><br><div><li>👍 2067</li><li>👎 64</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new MaximumSizeSubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            int maxLen = 0, sum = 0;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) maxLen = i + 1;
                if (hashMap.containsKey(sum - k)) maxLen = Math.max(maxLen, i - hashMap.get(sum - k));
                if (!hashMap.containsKey(sum)) hashMap.put(sum, i);
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}