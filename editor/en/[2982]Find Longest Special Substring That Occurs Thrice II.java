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
 * 3 <= s.length <= 5 * 10⁵
 * s consists of only lowercase English letters.
 * <p>
 * <p>
 * Related Topics Hash Table String Binary Search Sliding Window Counting 👍 362 ?
 * ? 29
 */

package com.shuzijun.leetcode.editor.en;

public class FindLongestSpecialSubstringThatOccursThriceIi {
    public static void main(String[] args) {
        Solution solution = new FindLongestSpecialSubstringThatOccursThriceIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(String s) {
            int n = s.length();
            int[][] freq = new int[26][n + 1];
            char pre = s.charAt(0);
            int len = 1;
            freq[pre - 'a'][len] = 1;
            int ans = -1;
            for (int i = 1; i < n; i++) {
                char cur = s.charAt(i);
                if (pre == cur) {
                    len++;
                    freq[cur - 'a'][len] += 1;
                } else {
                    len = 1;
                    freq[cur - 'a'][len] += 1;
                    pre = cur;
                }
            }
            for (int i = 0; i < 26; i++) {
                int prefixSum = 0;
                for (int j = n; j >= 1; j--) {
                    prefixSum += freq[i][j];
                    if (prefixSum >= 3) {
                        ans = Math.max(ans, j);
                        break;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}