//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// Every close bracket has a corresponding open bracket of the same type. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of parentheses only '()[]{}'. 
// 
//
// Related Topics String Stack 👍 22100 👎 1480


package com.shuzijun.leetcode.editor.en;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                        stack.push(1);
                        break;
                    case '[':
                        stack.push(2);
                        break;
                    case '{':
                        stack.push(3);
                        break;
                    case ')':
                        if (stack.empty()) return false;
                        if (stack.pop() != 1) return false;
                        else continue;
                    case ']':
                        if (stack.empty()) return false;
                        if (stack.pop() != 2) return false;
                        else continue;
                    case '}':
                        if (stack.empty()) return false;
                        if (stack.pop() != 3) return false;
                        else continue;
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}