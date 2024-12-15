/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] is either '(' , ')', or lowercase English letter.
 * <p>
 * <p>
 * Related Topics String Stack 👍 7028 👎 152
 */

package com.shuzijun.leetcode.editor.en;

import java.util.HashSet;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        Solution solution = new MinimumRemoveToMakeValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minRemoveToMakeValid(String s) {
/*            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            HashSet<Integer> removed = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') stack.push(i);
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        removed.add(i);
                        continue;
                    }
                    stack.pop();
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (!stack.contains(i) && !removed.contains(i))
                    sb.append(s.charAt(i));
            }
            return sb.toString();*/

            // Pass 1: Remove all invalid ")"
            StringBuilder sb = new StringBuilder();
            int openSeen = 0;
            int balance = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    openSeen++;
                    balance++;
                }
                if (c == ')') {
                    if (balance == 0) continue; // Skip invalid ')'
                    balance--;
                }
                sb.append(c);
            }

            // Pass 2: Remove the rightmost "("
            StringBuilder result = new StringBuilder();
            int openToKeep = openSeen - balance; // How many '(' we need to keep
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '(') {
                    openToKeep--;
                    if (openToKeep < 0) continue; // Skip extra '('
                }
                result.append(c);
            }

            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}