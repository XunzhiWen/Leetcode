/**
 * Given an input string s and a pattern p, implement regular expression matching
 * with support for '.' and '*' where:
 * <p>
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore,
 * by repeating 'a' once, it becomes "aa".
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a
 * previous valid character to match.
 * <p>
 * <p>
 * Related Topics String Dynamic Programming Recursion 👍 12559 👎 2255
 */

package com.shuzijun.leetcode.editor.en;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
//            dp[i][j]代表长度为i的s和长度为j的p的匹配结果
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;  // 空字符串可以互相匹配
//            a*b*这种形式也可以处理空字符串，所以需要额外处理
            for (int i = 2; i <= n; i += 2) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = dp[0][i - 2];
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    char sChar = s.charAt(i - 1);
                    char pChar = p.charAt(j - 1);

                    if (pChar == '*') {
                        char preChar = p.charAt(j - 2);
                        dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (sChar == preChar || preChar == '.'));
                    } else if (pChar == '.' || pChar == sChar) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}