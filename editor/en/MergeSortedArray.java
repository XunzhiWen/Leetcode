/**
 * <p>You are given two integer arrays <code>nums1</code> and <code>nums2</code>, sorted in <strong>non-decreasing order</strong>, and two integers <code>m</code> and <code>n</code>, representing the number of elements in <code>nums1</code> and <code>nums2</code> respectively.</p>
 *
 * <p><strong>Merge</strong> <code>nums1</code> and <code>nums2</code> into a single array sorted in <strong>non-decreasing order</strong>.</p>
 *
 * <p>The final sorted array should not be returned by the function, but instead be <em>stored inside the array </em><code>nums1</code>. To accommodate this, <code>nums1</code> has a length of <code>m + n</code>, where the first <code>m</code> elements denote the elements that should be merged, and the last <code>n</code> elements are set to <code>0</code> and should be ignored. <code>nums2</code> has a length of <code>n</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <strong>Output:</strong> [1,2,2,3,5,6]
 * <strong>Explanation:</strong> The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [<u>1</u>,<u>2</u>,2,<u>3</u>,5,6] with the underlined elements coming from nums1.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [1], m = 1, nums2 = [], n = 0
 * <strong>Output:</strong> [1]
 * <strong>Explanation:</strong> The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums1 = [0], m = 0, nums2 = [1], n = 1
 * <strong>Output:</strong> [1]
 * <strong>Explanation:</strong> The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>nums1.length == m + n</code></li>
 * <li><code>nums2.length == n</code></li>
 * <li><code>0 &lt;= m, n &lt;= 200</code></li>
 * <li><code>1 &lt;= m + n &lt;= 200</code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up: </strong>Can you come up with an algorithm that runs in <code>O(m + n)</code> time?</p>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Two Pointers</li><li>Sorting</li></div></div><br><div><li>👍 9518</li><li>👎 891</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            /* My Original Idea was to start from the left side, which will involve changing nums1's
             * order, so I used a temporary array to store nums1, which led to memory and time waste.
             *
             * Another brilliant idea was to start from the right side of the arrays since these numbers
             * are sorted in non-descending order. By applying this method, there will involve no
             * change in orders */

            int i = m - 1;
            int j = n - 1;
            int index = nums1.length - 1;
            while (j >= 0) {
                if (i>=0&&nums1[i]>=nums2[j])
//        No matter which condition does not hold, we should switch to nums2 and copy numbers there.
                {
                    nums1[index]=nums1[i];
                    i--;
                }
                else {
                    nums1[index] = nums2[j];
                    j--;
                }
                index--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}