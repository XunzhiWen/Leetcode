/**
 * <p>The <strong>array-form</strong> of an integer <code>num</code> is an array representing its digits in left to right order.</p>
 *
 * <ul>
 * <li>For example, for <code>num = 1321</code>, the array form is <code>[1,3,2,1]</code>.</li>
 * </ul>
 *
 * <p>Given <code>num</code>, the <strong>array-form</strong> of an integer, and an integer <code>k</code>, return <em>the <strong>array-form</strong> of the integer</em> <code>num + k</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = [1,2,0,0], k = 34
 * <strong>Output:</strong> [1,2,3,4]
 * <strong>Explanation:</strong> 1200 + 34 = 1234
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = [2,7,4], k = 181
 * <strong>Output:</strong> [4,5,5]
 * <strong>Explanation:</strong> 274 + 181 = 455
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num = [2,1,5], k = 806
 * <strong>Output:</strong> [1,0,2,1]
 * <strong>Explanation:</strong> 215 + 806 = 1021
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= num.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= num[i] &lt;= 9</code></li>
 * <li><code>num</code> does not contain any leading zeros except for the zero itself.</li>
 * <li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Math</li></div></div><br><div><li>👍 3487</li><li>👎 297</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> result = new LinkedList<>();
            int ptr = num.length - 1, carry = k;
            while (ptr >= 0 || carry != 0) {
                int x = ptr >= 0 ? num[ptr] : 0;
                carry += x;
                result.add(carry % 10);
                carry /= 10;
                ptr--;
            }
            Collections.reverse(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}