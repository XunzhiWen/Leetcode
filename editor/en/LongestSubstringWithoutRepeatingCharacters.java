//Given a string s, find the length of the longest substring without repeating
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 37174 👎 1670


package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * The best implementation is to use Hashmap to store chars with the index
         * if its last duplicates.
         *
         * Window Sliding is a common method in dealing with String or Array question
         *
         * When sliding the windows, just skip the duplicated char and start from the next
         * */
        public int lengthOfLongestSubstring(String s) {
            int result = 0;
            int n = s.length();
            HashMap<Character, Integer> hashmap = new HashMap<>();
            for (int i = 0, j = 0; j < n; j++) {
                if (hashmap.containsKey(s.charAt(j))) {
//                    index i only needs to start from the NEXT index of previous duplicate
                    i = Math.max(hashmap.get(s.charAt(j)) + 1, i);
                }
                result = Math.max(result, j - i + 1);
                hashmap.put(s.charAt(j), j);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}