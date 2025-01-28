//Given a string s, return the number of palindromic substrings in it.
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
//
// Related Topics Two Pointers String Dynamic Programming 👍 11001 👎 242


package com.shuzijun.leetcode.editor.en;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
/*//        布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
            char[] chars = s.toCharArray();
            int len = chars.length;
            boolean[][] dp = new boolean[len][len];
            int result = 0;
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    if (chars[i] == chars[j]) {
                        if (j - i <= 1) { // 情况一 和 情况二
                            result++;
                            dp[i][j] = true;
                        } else if (dp[i + 1][j - 1]) { //情况三
                            result++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return result;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}