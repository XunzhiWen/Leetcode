/**
 * <p>Given two binary strings <code>a</code> and <code>b</code>, return <em>their sum as a binary string</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> a = "11", b = "1"
 * <strong>Output:</strong> "100"
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> a = "1010", b = "1011"
 * <strong>Output:</strong> "10101"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>a</code> and <code>b</code> consist&nbsp;only of <code>'0'</code> or <code>'1'</code> characters.</li>
 * <li>Each string does not contain leading zeros except for the zero itself.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Math</li><li>String</li><li>Bit Manipulation</li><li>Simulation</li></div></div><br><div><li>👍 9612</li><li>👎 1006</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int ptr1 = a.length() - 1, ptr2 = b.length() - 1;
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (ptr1 >= 0 || ptr2 >= 0 || carry != 0) {
                int x1 = ptr1 >= 0 ? a.charAt(ptr1) - '0' : 0;
                int x2 = ptr2 >= 0 ? b.charAt(ptr2) - '0' : 0;
                int sum = x1 + x2 + carry;
                stringBuilder.append(sum % 2);
                carry = sum / 2;
                ptr1--;
                ptr2--;

            }
            return stringBuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}