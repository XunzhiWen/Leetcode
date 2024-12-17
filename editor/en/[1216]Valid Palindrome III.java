/**
 * Given a string s and an integer k, return true if s is a k-palindrome.
 * <p>
 * A string is k-palindrome if it can be transformed into a palindrome by
 * removing at most k characters from it.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "abcdeca", k = 2
 * Output: true
 * Explanation: Remove 'b' and 'e' characters.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abbababa", k = 1
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s consists of only lowercase English letters.
 * 1 <= k <= s.length
 * <p>
 * <p>
 * Related Topics String Dynamic Programming 👍 792 👎 14
 */

package com.shuzijun.leetcode.editor.en;

public class ValidPalindromeIii {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidPalindrome(String s, int k) {
            int n = s.length();
            int[][] dp = new int[n][n];
            return helper(s, dp, 0, n - 1) <= k;
        }

        private int helper(String s, int[][] dp, int i, int j) {
            if (i >= j) return 0;
            if (dp[i][j] != 0) return dp[i][j];
            if (s.charAt(i) == s.charAt(j)) dp[i][j] = helper(s, dp, i + 1, j - 1);
            else dp[i][j] = Math.min(helper(s, dp, i + 1, j), helper(s, dp, i, j - 1)) + 1;
            return dp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}