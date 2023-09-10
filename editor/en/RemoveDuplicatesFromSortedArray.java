/**
 * <p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing order</strong>, remove the duplicates <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a> such that each unique element appears only <strong>once</strong>. The <strong>relative order</strong> of the elements should be kept the <strong>same</strong>.</p>
 *
 * <p>Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the <strong>first part</strong> of the array <code>nums</code>. More formally, if there are <code>k</code> elements after removing the duplicates, then the first <code>k</code> elements of <code>nums</code>&nbsp;should hold the final result. It does not matter what you leave beyond the first&nbsp;<code>k</code>&nbsp;elements.</p>
 *
 * <p>Return <code>k</code><em> after placing the final result in the first </em><code>k</code><em> slots of </em><code>nums</code>.</p>
 *
 * <p>Do <strong>not</strong> allocate extra space for another array. You must do this by <strong>modifying the input array <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a></strong> with O(1) extra memory.</p>
 *
 * <p><strong>Custom Judge:</strong></p>
 *
 * <p>The judge will test your solution with the following code:</p>
 *
 * <pre>
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i &lt; k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * </pre>
 *
 * <p>If all assertions pass, then your solution will be <strong>accepted</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,1,2]
 * <strong>Output:</strong> 2, nums = [1,2,_]
 * <strong>Explanation:</strong> Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [0,0,1,1,1,2,2,3,3,4]
 * <strong>Output:</strong> 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * <strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * <li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
 * <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Two Pointers</li></div></div><br><div><li>👍 10195</li><li>👎 13857</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* Two pointers, one pointing at the current location where elements before are unique elements,
        * and the other pointing at the element that is being traversed */
        public int removeDuplicates(int[] nums) {
            int insertingIndex=1;
            for (int i =1;i< nums.length;i++){
                if (nums[i]!=nums[i-1]){
                    nums[insertingIndex]=nums[i];
                    insertingIndex++;
                }
            }
            return insertingIndex;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}