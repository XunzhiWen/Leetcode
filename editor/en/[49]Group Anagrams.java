//Given an array of strings strs, group the anagrams together. You can return
//the answer in any order. 
//
// 
// Example 1: 
//
// 
// Input: strs = ["eat","tea","tan","ate","nat","bat"] 
// 
//
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// Explanation: 
//
// 
// There is no string in strs that can be rearranged to form "bat". 
// The strings "nat" and "tan" are anagrams as they can be rearranged to form 
//each other. 
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged 
//to form each other. 
// 
//
// Example 2: 
//
// 
// Input: strs = [""] 
// 
//
// Output: [[""]] 
//
// Example 3: 
//
// 
// Input: strs = ["a"] 
// 
//
// Output: [["a"]] 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Sorting 👍 20074 👎 667


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> hashMap = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sortedStr = new String(chars);
                hashMap.putIfAbsent(sortedStr, new ArrayList<>());
                hashMap.get(sortedStr).add(str);
            }
            List<List<String>> res = new ArrayList<>();
            for (String keys : hashMap.keySet()) {
                res.add(hashMap.get(keys));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}