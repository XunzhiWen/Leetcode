/**
 * <p>You are given an <code>n x n</code> binary matrix <code>grid</code>. You are allowed to change <strong>at most one</strong> <code>0</code> to be <code>1</code>.</p>
 *
 * <p>Return <em>the size of the largest <strong>island</strong> in</em> <code>grid</code> <em>after applying this operation</em>.</p>
 *
 * <p>An <strong>island</strong> is a 4-directionally connected group of <code>1</code>s.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> grid = [[1,0],[0,1]]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> grid = [[1,1],[1,0]]
 * <strong>Output:</strong> 4
 * <strong>Explanation: </strong>Change the 0 to 1 and make the island bigger, only one island with area = 4.</pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> grid = [[1,1],[1,1]]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Can't change any 0 to 1, only one island with area = 4.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == grid.length</code></li>
 * <li><code>n == grid[i].length</code></li>
 * <li><code>1 &lt;= n &lt;= 500</code></li>
 * <li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Depth-First Search</li><li>Breadth-First Search</li><li>Union Find</li><li>Matrix</li></div></div><br><div><li>👍 4030</li><li>👎 80</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new MakingALargeIsland().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestIsland(int[][] grid) {
            HashMap<Integer, Integer> regionArea = new HashMap<>();
            regionArea.put(0, 0);
            int region = 2, m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    regionArea.put(region, dfs(grid, i, j, region));
                    region++;
                }
            }

            int max = regionArea.get(2);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        Set<Integer> neighbors = new HashSet<>();
                        neighbors.add(i > 0 ? grid[i - 1][j] : 0);
                        neighbors.add(j > 0 ? grid[i][j - 1] : 0);
                        neighbors.add(i < m - 1 ? grid[i + 1][j] : 0);
                        neighbors.add(j < n - 1 ? grid[i][j + 1] : 0);
                        int area = 1;
                        for (int neighbor : neighbors) {
                            area += regionArea.get(neighbor);
                        }
                        max = Math.max(max, area);
                    }
                }
            }
            return max;
        }

        private int dfs(int[][] grid, int i, int j, int region) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
            grid[i][j] = region;
            int sum = 1;
            sum += dfs(grid, i + 1, j, region);
            sum += dfs(grid, i, j + 1, region);
            sum += dfs(grid, i - 1, j, region);
            sum += dfs(grid, i, j - 1, region);

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}