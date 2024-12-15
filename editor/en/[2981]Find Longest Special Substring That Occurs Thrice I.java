/**
 * You are given a string s that consists of lowercase English letters.
 * <p>
 * A string is called special if it is made up of only a single character. For
 * example, the string "abc" is not special, whereas the strings "ddd", "zz", and "f"
 * are special.
 * <p>
 * Return the length of the longest special substring of s which occurs at least
 * thrice, or -1 if no special substring occurs at least thrice.
 * <p>
 * A substring is a contiguous non-empty sequence of characters within a string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "aaaa"
 * Output: 2
 * Explanation: The longest special substring which occurs thrice is "aa":
 * substrings "aaaa", "aaaa", and "aaaa".
 * It can be shown that the maximum length achievable is 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abcdef"
 * Output: -1
 * Explanation: There exists no special substring which occurs at least thrice.
 * Hence return -1.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "abcaba"
 * Output: 1
 * Explanation: The longest special substring which occurs thrice is "a":
 * substrings "abcaba", "abcaba", and "abcaba".
 * It can be shown that the maximum length achievable is 1.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 3 <= s.length <= 50
 * s consists of only lowercase English letters.
 * <p>
 * <p>
 * Related Topics Hash Table String Binary Search Sliding Window Counting 👍 654 ?
 * ? 59
 */

package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class FindLongestSpecialSubstringThatOccursThriceI {
    public static void main(String[] args) {
        Solution solution = new FindLongestSpecialSubstringThatOccursThriceI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(String s) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int res = -1;
            for (int start = 0; start < s.length(); start++) {
                char c = s.charAt(start);
                int length = 0;
                for (int end = start; end < s.length(); end++) {
                    if (s.charAt(end) == c) {
                        length++;
                        String key = c + '-' + String.valueOf(length);
                        hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
                        if (hashMap.get(key) >= 3) res = Math.max(length, res);
                    } else break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}