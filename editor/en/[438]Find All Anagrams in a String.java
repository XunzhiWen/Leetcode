//Given two strings s and p, return an array of all the start indices of p's
//anagrams in s. You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 12612 👎 348


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s.length() < p.length()) return res;

            int[] word = new int[26];  // 记录 p 的字符频率
            int[] window = new int[26];  // 记录当前窗口内字符频率
            int n = p.length();
            char[] chars = s.toCharArray();


            for (char c : p.toCharArray()) {
                word[c - 'a']++;
            }

            // 先填充第一个窗口
            for (int i = 0; i < n; i++) {
                window[chars[i] - 'a']++;
            }

            // 检查第一个窗口是否匹配
            if (Arrays.equals(word, window)) res.add(0);

            // 滑动窗口遍历 s
            for (int i = 1; i <= s.length() - n; i++) {
                window[chars[i - 1] - 'a']--;  // 移除前一个字符
                window[chars[i + n - 1] - 'a']++;  // 添加新字符

                if (Arrays.equals(word, window)) {
                    res.add(i);
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}