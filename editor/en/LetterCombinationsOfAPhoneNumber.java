//Given a string containing digits from 2-9 inclusive, return all possible
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
// 
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
//
// Related Topics Hash Table String Backtracking 👍 17189 👎 899


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> combinations = new ArrayList<>();
        private Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        private String phoneDigits;

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return combinations;
            }
            phoneDigits=digits;
            backTrack(0,new StringBuilder());
            return combinations;

        }
        private void backTrack(int index, StringBuilder path){
            if (phoneDigits.length()==path.length()){
                combinations.add(path.toString());
                return;
            }
            for (char ch:letters.get(phoneDigits.charAt(index)).toCharArray()){
                path.append(ch);
                backTrack(index+1,path);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}