//Write a function to find the longest common prefix string amongst an array of
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lowercase English letters. 
// 
//
// Related Topics String Trie 👍 15877 👎 4215


package com.shuzijun.leetcode.editor.en;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            if (n == 0) return "";
            String result = strs[0];
//            This implementation used a little bit more memory
/*            for (int i = 0; i < n - 1; i++) {
                String cur = twoCommonPrefix(strs[i], strs[i + 1]);
                result = twoCommonPrefix(result, cur);
                if (Objects.equals(result, "")) {
                    break;
                }
            }*/

//            Simpler and more memory-efficient way
            for (int i = 1; i < n; i++) {
                while (strs[i].indexOf(result) != 0) {
                    result = result.substring(0, result.length() - 1);
                    if (result.isEmpty()) break;
                }
            }
            return result;
        }

        private String twoCommonPrefix(String str1, String str2) {
            int n = Math.min(str1.length(), str2.length());
            String res = "";
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    res += str1.charAt(i);
                } else {
                    break;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}