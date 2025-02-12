//You are given a string sentence that consist of words separated by spaces.
//Each word consists of lowercase and uppercase letters only. 
//
// We would like to convert the sentence to "Goat Latin" (a made-up language 
//similar to Pig Latin.) The rules of Goat Latin are as follows: 
//
// 
// If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to 
//the end of the word. 
// 
//
// 
// For example, the word "apple" becomes "applema". 
// 
// 
// If a word begins with a consonant (i.e., not a vowel), remove the first 
//letter and append it to the end, then add "ma".
// 
// For example, the word "goat" becomes "oatgma". 
// 
// 
// Add one letter 'a' to the end of each word per its word index in the 
//sentence, starting with 1.
// 
// For example, the first word gets "a" added to the end, the second word gets 
//"aa" added to the end, and so on. 
// 
// 
//
//
// Return the final sentence representing the conversion from sentence to Goat 
//Latin. 
//
// 
// Example 1: 
// Input: sentence = "I speak Goat Latin"
//Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
// 
// Example 2: 
// Input: sentence = "The quick brown fox jumped over the lazy dog"
//Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa 
//hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
// 
// 
// Constraints: 
//
// 
// 1 <= sentence.length <= 150 
// sentence consists of English letters and spaces. 
// sentence has no leading or trailing spaces. 
// All the words in sentence are separated by a single space. 
// 
//
// Related Topics String 👍 930 👎 1251


package com.shuzijun.leetcode.editor.en;

import java.util.HashSet;

public class GoatLatin {
    public static void main(String[] args) {
        Solution solution = new GoatLatin().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toGoatLatin(String sentence) {
            String[] words = sentence.split(" ");
            HashSet<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (vowels.contains(words[i].charAt(0))) {
                    sb.append(words[i]);
                } else {
                    sb.append(words[i].substring(1));
                    sb.append(words[i].charAt(0));
                }
                sb.append("ma");
                sb.append("a".repeat(i+1));
                sb.append(" ");
            }
            sb.delete(sb.length() - 1, sb.length());
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}