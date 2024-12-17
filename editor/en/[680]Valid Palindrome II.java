/**
 * Given a string s, return true if the s can be palindrome after deleting at most
 * one character from it.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "aba"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "abc"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s consists of lowercase English letters.
 * <p>
 * <p>
 * Related Topics Two Pointers String Greedy 👍 8406 👎 464
 */

package com.shuzijun.leetcode.editor.en;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return checkPalindrome(s, left + 1, right) || checkPalindrome(s, left, right - 1);
                }
                left++;
                right--;
            }
            return true;

        }

        private boolean checkPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}