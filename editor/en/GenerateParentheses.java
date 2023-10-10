//Given n pairs of parentheses, write a function to generate all combinations
//of well-formed parentheses. 
//
// 
// Example 1: 
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// 
// Example 2: 
// Input: n = 1
//Output: ["()"]
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics String Dynamic Programming Backtracking 👍 19659 👎 800


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // solution 1: Backtracking
//        List<String> result = new ArrayList<>();
//
//        public List<String> generateParenthesis(int n) {
//
//            backTracking(n,n,n,new StringBuilder());
//            return result;
//
//        }
//
//        private void backTracking(int n, int left, int right, StringBuilder curString) {
//            if (curString.length() == 2 * n) {
//                result.add(curString.toString());
//            }
//            if (left > 0) {
//                curString.append('(');
//                backTracking(n, left - 1, right, curString);
//                curString.deleteCharAt(curString.length() - 1);
//            }
//            if (right > left) {
//                curString.append(')');
//                backTracking(n, left, right - 1, curString);
//                curString.deleteCharAt(curString.length() - 1);
//            }
//        }

        //        Solution 2: Dynamic Programming
        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return new ArrayList<>(Arrays.asList(""));
            }
            List<String> result = new ArrayList<>();
            for (int left = 0; left < n; left++) {
                for (String leftString : generateParenthesis(left)) {
                    for (String rightString : generateParenthesis(n - 1 - left)) {
                        result.add("(" + leftString + ")" + rightString);
                    }
                }
            }
            return result;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}