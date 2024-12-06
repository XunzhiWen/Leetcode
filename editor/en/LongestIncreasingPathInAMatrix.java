//Given an m x n integers matrix, return the length of the longest increasing
//path in matrix. 
//
// From each cell, you can either move in four directions: left, right, up, or 
//down. You may not move diagonally or move outside the boundary (i.e., wrap-
//around is not allowed). 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
//Output: 4
//Explanation: The longest increasing path is [1, 2, 6, 9].
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
//Output: 4
//Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally 
//is not allowed.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// Related Topics Array Dynamic Programming Depth-First Search Breadth-First 
//Search Graph Topological Sort Memoization Matrix 👍 9076 👎 139


package com.shuzijun.leetcode.editor.en;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] cache = new int[m][n];
            int maxLen = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maxLen = Math.max(maxLen, dfs(matrix, cache, i, j));
                }
            }
            return maxLen;
        }

        private int dfs(int[][] matrix, int[][] cache, int r, int c) {
            if (cache[r][c] != 0) return cache[r][c];
            int maxLen = 1;
            for (int[] dir : DIRECTIONS) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR >= 0 && newR < matrix.length && newC >= 0 && newC < matrix[0].length && matrix[newR][newC] > matrix[r][c]) {
                    maxLen = Math.max(maxLen, 1 + dfs(matrix, cache, newR, newC));
                }
            }
            cache[r][c] = maxLen;
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}