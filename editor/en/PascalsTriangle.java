/**
 * <p>Given an integer <code>numRows</code>, return the first numRows of <strong>Pascal's triangle</strong>.</p>
 *
 * <p>In <strong>Pascal's triangle</strong>, each number is the sum of the two numbers directly above it as shown:</p>
 * <img alt="" src="https://upload.wikimedia.org/wikipedia/commons/0/0d/PascalTriangleAnimated2.gif" style="height:240px; width:260px" />
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> numRows = 5
 * <strong>Output:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> numRows = 1
 * <strong>Output:</strong> [[1]]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= numRows &lt;= 30</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Dynamic Programming</li></div></div><br><div><li>👍 9356</li><li>👎 304</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        int numRows = 5;
        System.out.println(solution.generate(numRows).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            /* There are several important tricks:
             * 1. Be careful about Reference Passing and Value Passing. We have to make sure that
             * lists stored in Result will never change again, so we have to clone.
             * 2. Arraylist.add() is not an in-place operation, so it can't overwrite the value
             * at the indexed position. We have to reset the arraylist everytime. */
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            List<List<Integer>> result = new ArrayList<>();
            if (numRows <= 0) {
                return result;
            }
            result.add((ArrayList<Integer>) row.clone());
            if (numRows == 1) {
                return result;
            } else {
                row.add(1);
                result.add((ArrayList<Integer>) row.clone());
                for (int i = 1; i < numRows - 1; i++) {
//       Reset the arraylist we want to modify, otherwise we will append things to original arraylist
                    ArrayList<Integer> newRow = new ArrayList<>();
                    newRow.add(1);
                    newRow.add(1);
                    for (int j = 0; j < row.size() - 1; j++) {
                        newRow.add(j + 1, row.get(j) + row.get(j + 1));
                    }
                    result.add(newRow);
                    row = (ArrayList<Integer>) newRow.clone();
                }
            }
            return result;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}