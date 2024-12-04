//Given a string s and a dictionary of strings wordDict, return true if s can
//be segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in 
//the segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple 
//pen apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
//
// Related Topics Array Hash Table String Dynamic Programming Trie Memoization ?
//? 17551 👎 826


package com.shuzijun.leetcode.editor.en;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            TrieNode root = buildTrie(wordDict);
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[s.length() + 1];
            queue.add(0);
            while (!queue.isEmpty()) {
                int start = queue.poll();
                if (visited[start]) continue;
                visited[start] = true;
                TrieNode node = root;
                for (int end = start; end < s.length(); end++) {
                    char c = s.charAt(end);
                    if (!node.children.containsKey(c)) break;
                    node = node.children.get(c);

                    if (node.isWord) {
                        if (end + 1 == s.length()) return true;
                        queue.add(end + 1);
                    }
                }
            }
            return false;
        }

        private TrieNode buildTrie(List<String> wordDict) {
            TrieNode root = new TrieNode();
            for (String word : wordDict) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    node.children.putIfAbsent(c, new TrieNode());
                    node = node.children.get(c);
                }
                node.isWord = true;
            }
            return root;
        }

        class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isWord = false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}