/**
 * <p>Given an integer <code>rowIndex</code>, return the <code>rowIndex<sup>th</sup></code> (<strong>0-indexed</strong>) row of the <strong>Pascal's triangle</strong>.</p>
 *
 * <p>In <strong>Pascal's triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
 * <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height:240px; width:260px" />
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> rowIndex = 3
 * <strong>Output:</strong> [1,3,3,1]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> rowIndex = 0
 * <strong>Output:</strong> [1]
 * </pre>
 * <p><strong class="example">Example 3:</strong></p>
 * <pre><strong>Input:</strong> rowIndex = 1
 * <strong>Output:</strong> [1,1]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>0 &lt;= rowIndex &lt;= 33</code></li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong> Could you optimize your algorithm to use only <code>O(rowIndex)</code> extra space?</p>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Dynamic Programming</li></div></div><br><div><li>👍 3589</li><li>👎 294</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        int rowIndex = 3;
        System.out.println(solution.getRow(rowIndex).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            ArrayList<Integer> result = new ArrayList<>();
            if (rowIndex < 0) {
                return result;
            }
            result.add(1);
            if (rowIndex == 0) {
                return result;
            }
            result.add(1);
            for (int i = 1; i < rowIndex; i++) {
                ArrayList<Integer> prevRow = (ArrayList<Integer>) result.clone();
                result=new ArrayList<>();
                result.add(1);
                result.add(1);
                for (int j=1;j<i+1;j++){
                    result.add(j,prevRow.get(j-1)+prevRow.get(j));
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}