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
// Related Topics Two Pointers String Dynamic Programming 👍 10949 👎 241


package com.shuzijun.leetcode.editor.en;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                ans += checkCenter(s, i, i);
                ans += checkCenter(s, i, i + 1);
            }
            return ans;
        }

        private int checkCenter(String s, int i, int j) {
            int ans = 0;
            while (i >= 0 && j < s.length()) {
                if (s.charAt(i) != s.charAt(j)) break;
                i--;
                j++;
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}