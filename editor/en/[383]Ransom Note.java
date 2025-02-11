//Given two strings ransomNote and magazine, return true if ransomNote can be
//constructed by using the letters from magazine and false otherwise. 
//
// Each letter in magazine can only be used once in ransomNote. 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// 
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// 
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote and magazine consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Counting 👍 5233 👎 520


package com.shuzijun.leetcode.editor.en;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] word = new int[26];
            for (char c : magazine.toCharArray()) {
                word[c - 'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                word[c - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (word[i] < 0) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}