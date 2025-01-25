//Given two strings text1 and text2, return the length of their longest common
//subsequence. If there is no common subsequence, return 0. 
//
// A subsequence of a string is a new string generated from the original string 
//with some characters (can be none) deleted without changing the relative order 
//of the remaining characters. 
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// A common subsequence of two strings is a subsequence that is common to both 
//strings. 
//
// 
// Example 1: 
//
// 
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3  
//Explanation: The longest common subsequence is "ace" and its length is 3.
// 
//
// Example 2: 
//
// 
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
// 
//
// Example 3: 
//
// 
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
// 
//
// 
// Constraints: 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 and text2 consist of only lowercase English characters. 
// 
//
// Related Topics String Dynamic Programming 👍 13962 👎 211


package com.shuzijun.leetcode.editor.en;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
/*            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//            dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
            int res = 0;
            for (int i = 1; i <= text1.length(); i++) {
                char c1 = text1.charAt(i - 1);
                for (int j = 1; j <= text2.length(); j++) {
                    char c2 = text2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res;*/
//            一维滚动数组优化
            if (text1.length() < text2.length()) return longestCommonSubsequence(text2, text1);
            int[] dp = new int[text2.length() + 1];
            int prev, res = 0;
            for (int i = 1; i <= text1.length(); i++) {
                prev = dp[0];
                for (int j = 1; j <= text2.length(); j++) {
                    int temp = dp[j];
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[j] = prev + 1;
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }
                    prev = temp;
                    res = Math.max(res, dp[j]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}