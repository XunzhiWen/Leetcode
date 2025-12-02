/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * <p>
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "egg", t = "add"
 * <p>
 * <p>
 * Output: true
 * <p>
 * Explanation:
 * <p>
 * The strings s and t can be made identical by:
 * <p>
 * <p>
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "foo", t = "bar"
 * <p>
 * <p>
 * Output: false
 * <p>
 * Explanation:
 * <p>
 * The strings s and t can not be made identical as 'o' needs to be mapped to
 * both 'a' and 'r'.
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "paper", t = "title"
 * <p>
 * <p>
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 5 * 10⁴
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * <p>
 * <p>
 * Related Topics Hash Table String 👍 10215 👎 2260
 */

package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Character> hashMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i), tChar = t.charAt(i);
                if (hashMap.containsKey(sChar)) {
                    if (hashMap.get(sChar) != tChar) return false;
                } else {
                    if (hashMap.containsValue(tChar)) return false;
                    hashMap.put(sChar, tChar);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}