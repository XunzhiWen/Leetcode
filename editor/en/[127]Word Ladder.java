/**
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
 * be in wordList.
 * sk == endWord
 * <p>
 * <p>
 * Given two words, beginWord and endWord, and a dictionary wordList, return the
 * number of words in the shortest transformation sequence from beginWord to
 * endWord, or 0 if no such sequence exists.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
 * "log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" ->
 * "dog" -> cog", which is 5 words long.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
 * "log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid
 * transformation sequence.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 * <p>
 * <p>
 * Related Topics Hash Table String Breadth-First Search 👍 13201 👎 1956
 */

package com.shuzijun.leetcode.editor.en;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            int L = beginWord.length();
            HashMap<String, List<String>> patternMap = new HashMap<>();

//            Initiate pattern map

            for (String word : wordList) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < L; i++) {
                    char oldChar = chars[i];
                    chars[i] = '*';
                    String pattern = new String(chars);
                    patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
                    chars[i] = oldChar;
                }
            }

            HashSet<String> visited = new HashSet<>();
            HashSet<String> beginSet = new HashSet<>();
            HashSet<String> endSet = new HashSet<>();

            beginSet.add(beginWord);
            endSet.add(endWord);

            visited.add(beginWord);
            visited.add(endWord);
            int step = 1;

            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    HashSet<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                HashSet<String> nextLevel = new HashSet<>();

                for (String word : beginSet) {
                    char[] wordChars = word.toCharArray();
                    for (int i = 0; i < L; i++) {
                        char oldChar = wordChars[i];
                        wordChars[i] = '*';
                        String pattern = new String(wordChars);
                        List<String> neighbors = patternMap.getOrDefault(pattern, Collections.emptyList());

                        for (String neighbor : neighbors) {
                            if (endSet.contains(neighbor)) {
                                return step + 1;
                            }
                            if (!visited.contains(neighbor)) {
                                visited.add(neighbor);
                                nextLevel.add(neighbor);
                            }
                        }
                        wordChars[i] = oldChar;
                    }
                }

                beginSet = nextLevel;
                step++;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}