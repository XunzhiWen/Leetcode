/**
 * <p>Perform the following shift operations on a string:</p>
 *
 * <ul>
 * <li><strong>Right shift</strong>: Replace every letter with the <strong>successive</strong> letter of the English alphabet, where 'z' is replaced by 'a'. For example, <code>"abc"</code> can be right-shifted to <code>"bcd" </code>or <code>"xyz"</code> can be right-shifted to <code>"yza"</code>.</li>
 * <li><strong>Left shift</strong>: Replace every letter with the <strong>preceding</strong> letter of the English alphabet, where 'a' is replaced by 'z'. For example, <code>"bcd"</code> can be left-shifted to <code>"abc"<font face="Times New Roman"> or </font></code><code>"yza"</code> can be left-shifted to <code>"xyz"</code>.</li>
 * </ul>
 *
 * <p>We can keep shifting the string in both directions to form an <strong>endless</strong> <strong>shifting sequence</strong>.</p>
 *
 * <ul>
 * <li>For example, shift <code>"abc"</code> to form the sequence: <code>... &lt;-&gt; "abc" &lt;-&gt; "bcd" &lt;-&gt; ... &lt;-&gt; "xyz" &lt;-&gt; "yza" &lt;-&gt; ...</code>.<code> &lt;-&gt; "zab" &lt;-&gt; "abc" &lt;-&gt; ...</code></li>
 * </ul>
 *
 * <p>You are given an array of strings <code>strings</code>, group together all <code>strings[i]</code> that belong to the same shifting sequence. You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">strings = ["abc","bcd","acef","xyz","az","ba","a","z"]</span></p>
 * </div>
 *
 * <p><strong>Output:</strong> <span class="example-io">[["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]</span></p>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">strings = ["a"]</span></p>
 * </div>
 *
 * <p><strong>Output:</strong> <span class="example-io">[["a"]]</span></p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= strings.length &lt;= 200</code></li>
 * <li><code>1 &lt;= strings[i].length &lt;= 50</code></li>
 * <li><code>strings[i]</code> consists of lowercase English letters.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>String</li></div></div><br><div><li>👍 1703</li><li>👎 400</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupShiftedStrings {
    public static void main(String[] args) {
        Solution solution = new GroupShiftedStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            HashMap<String, List<String>> hashMap = new HashMap<>();
            for (String str : strings) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < str.length(); i++) {
                    int diff = (str.charAt(0) - str.charAt(i) + 26) % 26;
                    sb.append('.');
                    sb.append(diff);
                }
                String key = sb.toString();

                if (!hashMap.containsKey(key)) hashMap.put(key, new LinkedList<>());
                hashMap.get(key).add(str);
            }
            List<List<String>> result = new LinkedList<>();
            for (String keys : hashMap.keySet()) {
                result.add(hashMap.get(keys));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}