/**
 * <p>You are given a string <code>s</code> consisting of lowercase English letters. A <strong>duplicate removal</strong> consists of choosing two <strong>adjacent</strong> and <strong>equal</strong> letters and removing them.</p>
 *
 * <p>We repeatedly make <strong>duplicate removals</strong> on <code>s</code> until we no longer can.</p>
 *
 * <p>Return <em>the final string after all such duplicate removals have been made</em>. It can be proven that the answer is <strong>unique</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "abbaca"
 * <strong>Output:</strong> "ca"
 * <strong>Explanation:</strong>
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> s = "azxxzy"
 * <strong>Output:</strong> "ay"
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>String</li><li>Stack</li></div></div><br><div><li>👍 6702</li><li>👎 265</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Objects;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            if (Objects.equals(s, "")) return "";
            Stack<Character> stack = new Stack<>();
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (stack.isEmpty() || arr[i] != stack.peek()) {
                    stack.push(arr[i]);
                    continue;
                }
                if (arr[i] == stack.peek()) stack.pop();
            }
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }

            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}