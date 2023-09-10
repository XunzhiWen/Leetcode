/**
 * <p>Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.</p>
 *
 * <p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,5,6], target = 5
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,5,6], target = 2
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,3,5,6], target = 7
 * <strong>Output:</strong> 4
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li><code>nums</code> contains <strong>distinct</strong> values sorted in <strong>ascending</strong> order.</li>
 * <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Binary Search</li></div></div><br><div><li>👍 12480</li><li>👎 548</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        int[] testNums = {1, 3, 5, 7};
        int testTarget = 6;
        System.out.println(solution.searchInsert(testNums, testTarget));
        System.out.println(Arrays.toString(testNums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            /* Use binary Search to realize runtime complexity of O(log n) */
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            int mid;
            if (target > nums[right]) {
                return n;
            }
//            The equal mark here is very tricky! Without it, you will just put the number on the left of correct answer, like returning 0 with
//            nums = [1,3,5,6] and target = 2.
            while (left <= right) {
                mid = (left + right) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
