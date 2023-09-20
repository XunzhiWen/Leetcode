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
// Related Topics Hash Table String Counting 👍 4520 👎 458


package com.shuzijun.leetcode.editor.en;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* string in Java has a function called indexOf(char), which can be used to find a
         * char in the string, returning -1 if none. So can use this to check.
         *
         * Should use HashMap instead of Hashtable, because we only store 1 element under
         * 1 char
         *
         * Also, we can use only one HashMap and subtract from it.
         *
         * Last idea is to sort two arrays in alphabetic order, then store them into
         * two stacks and pop repeatedly to compare which char is earlier.
         * */
        public boolean canConstruct(String ransomNote, String magazine) {
            boolean result = true;
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            java.util.HashMap<Character, Integer> input = new java.util.HashMap<>();
            java.util.HashMap<Character, Integer> target = new java.util.HashMap<>();

            for (char ch : magazine.toCharArray()) {
                if (input.containsKey(ch)) {
                    input.put(ch, input.get(ch) + 1);
                } else {
                    input.put(ch, 1);
                }
            }
            for (char ch : ransomNote.toCharArray()) {
                if (target.containsKey(ch)) {
                    target.put(ch, target.get(ch) + 1);
                } else {
                    target.put(ch, 1);
                }
            }
            for (char ch : target.keySet()) {
                if (!input.containsKey(ch) || input.get(ch) < target.get(ch)) {
                    result = false;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}