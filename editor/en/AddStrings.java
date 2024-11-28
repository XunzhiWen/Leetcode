/**
 * <p>Given two non-negative integers, <code>num1</code> and <code>num2</code> represented as string, return <em>the sum of</em> <code>num1</code> <em>and</em> <code>num2</code> <em>as a string</em>.</p>
 *
 * <p>You must solve the problem without using any built-in library for handling large integers (such as <code>BigInteger</code>). You must also not convert the inputs to integers directly.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num1 = "11", num2 = "123"
 * <strong>Output:</strong> "134"
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num1 = "456", num2 = "77"
 * <strong>Output:</strong> "533"
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> num1 = "0", num2 = "0"
 * <strong>Output:</strong> "0"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= num1.length, num2.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>num1</code> and <code>num2</code> consist of only digits.</li>
 * <li><code>num1</code> and <code>num2</code> don't have any leading zeros except for the zero itself.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Math</li><li>String</li><li>Simulation</li></div></div><br><div><li>👍 5119</li><li>👎 768</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int ptr1 = num1.length() - 1, ptr2 = num2.length() - 1;
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (ptr1 >= 0 || ptr2 >= 0 || carry > 0) {
                int n1 = ptr1 >= 0 ? num1.charAt(ptr1) - '0' : 0;
                int n2 = ptr2 >= 0 ? num2.charAt(ptr2) - '0' : 0;
                int sum = n1 + n2 + carry;
                stringBuilder.append(sum%10);
                carry = sum / 10;
                ptr2--;
                ptr1--;
            }
            return stringBuilder.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}