//Given two strings s and t, return the number of distinct subsequences of s
//which equals t. 
//
// The test cases are generated so that the answer fits on a 32-bit signed 
//integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from s.
//rabbbit
//rabbbit
//rabbbit
// 
//
// Example 2: 
//
// 
//Input: s = "babgbag", t = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from s.
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 1000 
// s and t consist of English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 6861 👎 303


package com.shuzijun.leetcode.editor.en;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[s.length()][t.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}