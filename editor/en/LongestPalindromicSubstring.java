//Given a string s, return the longest palindromic substring in s.
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 27254 👎 1615


package com.shuzijun.leetcode.editor.en;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int expend(int i, int j, String s) {
            /* Return the max length of palindrome substring centered at (i,j) */
            int left = i, right = j;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }

        public String longestPalindrome(String s) {
            int n = s.length();
            int[] res = new int[]{0, 0};
            for (int i = 0; i < n; i++) {
                int oddLength = expend(i, i, s);
                if (oddLength > res[1] - res[0] + 1) {
                    res[0] = i - oddLength / 2;
                    res[1] = i + oddLength / 2;
                }
                int evenLength = expend(i, i + 1, s);
                if (evenLength > res[1] - res[0] + 1) {
                    res[0] = i - (evenLength / 2 - 1);
                    res[1] = i + (evenLength / 2 - 1) + 1;
                }
            }
            return s.substring(res[0], res[1] + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}