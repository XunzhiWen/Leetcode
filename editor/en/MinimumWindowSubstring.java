//Given two strings s and t of lengths m and n respectively, return the minimum
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
// Follow up: Could you find an algorithm that runs in O(m + n) time? 
//
// Related Topics Hash Table String Sliding Window 👍 17386 👎 701


package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> target = new HashMap<>();
//            初始化，记录目标字符串中每个字符出现的次数
            for (char c : t.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);
            int left = 0, right = 0, valid = 0;//出现次数已经匹配的字符串的个数
            int minLen = Integer.MAX_VALUE, start = 0;//当前字符串长度初始化为无穷大，start是选中字符串的起点
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                if (target.containsKey(c)) {//只有当遇到第一个包含在目标字符串中的字符时才开始记录滑窗
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (target.get(c).equals(window.get(c))) {
//                        说明该字符已经被完全匹配了
                        valid++;
                    }
                }

//                当窗口已经包含了所有目标字符时，开始缩小左端
                while (valid == target.size()) {
//                    更新当前最小滑窗的长度
                    if (right - left < minLen) {
                        minLen = right - left;
                        start = left;
                    }
//                    查看如果缩小左端，滑窗是否依然有效
                    char l = s.charAt(left);
                    if (target.containsKey(l)) {
                        window.put(l, window.get(l) - 1);
                        if (window.get(l) < target.get(l)) valid--;
                    }
                    left++;
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}