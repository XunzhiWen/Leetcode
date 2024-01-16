//Given a string containing just the characters '(' and ')', return the length
//of the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] is '(', or ')'. 
// 
//
// Related Topics String Dynamic Programming Stack 👍 11777 👎 367


package com.shuzijun.leetcode.editor.en;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        solution.longestValidParentheses(")()())");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
//        The following method exceeded time
//            int longest = 0, n = s.length();
//            int left = 0, right;
//            if (n < 2) {
//                return 0;
//            }
//            while (left < n - 1) {
//                for (right = left + 1; right < n; right++) {
//                    boolean flag = true;  // Mark if this left and right is valid
//                    boolean flag1 = true;
//                    Stack<Integer> stack = new Stack<>();
//                    for (int i = left; i <= right; i++) {
//                        if (s.charAt(i) == '(') {
//                            stack.push(1);
//                        }
//                        if (s.charAt(i) == ')') {
//                            if (stack.empty()) {
//                                flag1 = false;
//                                break;
//                            }
//                            stack.pop();
//                        }
//                        if (i == right && !stack.empty()) {
//                            flag = false;
//                            break;
//                        }
//                    }
//                    if (flag&&flag1) {
//                        longest = Math.max(longest, right - left + 1);
//                    }
//                    if (!flag1){
//                        break;
//                    }
//                }
//                left++;
//            }
//            return longest;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}