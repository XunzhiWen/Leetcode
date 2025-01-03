/**
 * <p>Given an <code>m x n</code> matrix <code>mat</code>, return <em>an array of all the elements of the array in a diagonal order</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/04/10/diag1-grid.jpg" style="width: 334px; height: 334px;" />
 * <pre>
 * <strong>Input:</strong> mat = [[1,2,3],[4,5,6],[7,8,9]]
 * <strong>Output:</strong> [1,2,4,7,5,3,6,8,9]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> mat = [[1,2],[3,4]]
 * <strong>Output:</strong> [1,2,3,4]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>m == mat.length</code></li>
 * <li><code>n == mat[i].length</code></li>
 * <li><code>1 &lt;= m, n &lt;= 10<sup>4</sup></code></li>
 * <li><code>1 &lt;= m * n &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>5</sup> &lt;= mat[i][j] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Matrix</li><li>Simulation</li></div></div><br><div><li>👍 3540</li><li>👎 707</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            if (mat.length == 0 || mat[0].length == 0) return new int[0];

            int r = 0, c = 0, m = mat.length, n = mat[0].length;
            int[] result = new int[m * n];
            for (int i = 0; i < result.length; i++) {
                result[i] = mat[r][c];
                if ((r + c) % 2 == 0) {
                    if (c == n - 1) r++;
                    else if (r == 0) c++;
                    else {
                        r--;
                        c++;
                    }
                } else {
                    if (r == m - 1) c++;
                    else if (c == 0) r++;
                    else {
                        r++;
                        c--;
                    }
                }
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
