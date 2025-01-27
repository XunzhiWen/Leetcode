//Given two strings s and t, return true if s is a subsequence of t, or false
//otherwise. 
//
// A subsequence of a string is a new string that is formed from the original 
//string by deleting some (can be none) of the characters without disturbing the 
//relative positions of the remaining characters. (i.e., "ace" is a subsequence of 
//"abcde" while "aec" is not). 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// 
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10⁴ 
// s and t consist only of lowercase English letters. 
// 
//
// 
//Follow up: Suppose there are lots of incoming 
//s, say 
//s1, s2, ..., sk where 
//k >= 10⁹, and you want to check one by one to see if 
//t has its subsequence. In this scenario, how would you change your code?
//
// Related Topics Two Pointers String Dynamic Programming 👍 10025 👎 566


package com.shuzijun.leetcode.editor.en;

public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
/*//            dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[s.length()][t.length()] == s.length();*/
//        滚动数组，状态压缩
            int[] dp = new int[s.length() + 1];
            for (int i = 1; i <= t.length(); i++) {
                for (int j = s.length(); j > 0; j--) {
                    if (s.charAt(j - 1) == t.charAt(i - 1)) {
                        dp[j] = dp[j - 1] + 1;
                    }
                }
            }
            return dp[s.length()] == s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}