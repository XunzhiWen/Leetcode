/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and
 * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the
 * Atlantic Ocean touches the island's right and bottom edges.
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n
 * integer matrix heights where heights[r][c] represents the height above sea level
 * of the cell at coordinate (r, c).
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring
 * cells directly north, south, east, and west if the neighboring cell's height is
 * less than or equal to the current cell's height. Water can flow from any cell
 * adjacent to an ocean into the ocean.
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes
 * that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic
 * oceans.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Explanation: The following cells can flow to the Pacific and Atlantic oceans,
 * as shown below:
 * [0,4]: [0,4] -> Pacific Ocean
 *        [0,4] -> Atlantic Ocean
 * [1,3]: [1,3] -> [0,3] -> Pacific Ocean
 *        [1,3] -> [1,4] -> Atlantic Ocean
 * [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
 *        [1,4] -> Atlantic Ocean
 * [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
 *        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
 * [3,0]: [3,0] -> Pacific Ocean
 *        [3,0] -> [4,0] -> Atlantic Ocean
 * [3,1]: [3,1] -> [3,0] -> Pacific Ocean
 *        [3,1] -> [4,1] -> Atlantic Ocean
 * [4,0]: [4,0] -> Pacific Ocean
 * [4,0] -> Atlantic Ocean
 * Note that there are other possible paths for these cells to flow to the Pacific
 * and Atlantic oceans.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: heights = [[1]]
 * Output: [[0,0]]
 * Explanation: The water can flow from the only cell to the Pacific and Atlantic
 * oceans.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 10⁵
 * <p>
 * <p>
 * Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 8536 👎
 * 1776
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                dfs(heights, i, 0, pacific, 0);
                dfs(heights, i, n - 1, atlantic, 0);
            }
            for (int i = 0; i < n; i++) {
                dfs(heights, 0, i, pacific, 0);
                dfs(heights, m - 1, i, atlantic, 0);
            }

            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        res.add(Arrays.asList(i, j));
                    }
                }

            }
            return res;

        }

        private void dfs(int[][] heights, int i, int j, boolean[][] visited, int preH) {
            if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j]) {
                return;
            }
            if (heights[i][j] < preH) {
                return;
            }
            visited[i][j] = true;

            dfs(heights, i - 1, j, visited, heights[i][j]);
            dfs(heights, i + 1, j, visited, heights[i][j]);
            dfs(heights, i, j - 1, visited, heights[i][j]);
            dfs(heights, i, j + 1, visited, heights[i][j]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}