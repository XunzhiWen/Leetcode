/**
 * <p>You are given an integer array <code>nums</code> consisting of <code>n</code> elements, and an integer <code>k</code>.</p>
 *
 * <p>Find a contiguous subarray whose <strong>length is equal to</strong> <code>k</code> that has the maximum average value and return <em>this value</em>. Any answer with a calculation error less than <code>10<sup>-5</sup></code> will be accepted.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,12,-5,-6,50,3], k = 4
 * <strong>Output:</strong> 12.75000
 * <strong>Explanation:</strong> Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [5], k = 1
 * <strong>Output:</strong> 5.00000
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == nums.length</code></li>
 * <li><code>1 &lt;= k &lt;= n &lt;= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Sliding Window</li></div></div><br><div><li>👍 3666</li><li>👎 341</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            long sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[j];
            }
            double maxAVG = (double) sum / k;
            for (int i = 0; i < nums.length - k; i++) {
                sum -= nums[i];
                sum += nums[i + k];
                maxAVG = Math.max(maxAVG, (double) sum / k);
            }
            return maxAVG;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}