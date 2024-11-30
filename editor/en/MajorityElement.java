/**
 * <p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>
 *
 * <p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [3,2,3]
 * <strong>Output:</strong> 3
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
 * <strong>Output:</strong> 2
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == nums.length</code></li>
 * <li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <strong>Follow-up:</strong> Could you solve the problem in linear time and in
 * <code>O(1)</code> space?
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>Divide and Conquer</li><li>Sorting</li><li>Counting</li></div></div><br><div><li>👍 19916</li><li>👎 674</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer number = null;

            for (int num : nums) {
                if (count == 0) number = num;
                count += num == number ? 1 : -1;
            }
            return number;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}