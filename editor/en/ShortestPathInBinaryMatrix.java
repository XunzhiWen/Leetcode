//Given an n x n binary matrix grid, return the length of the shortest clear
//path in the matrix. If there is no clear path, return -1. 
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0
//)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 
//
// 
// All the visited cells of the path are 0. 
// All the adjacent cells of the path are 8-directionally connected (i.e., they 
//are different and they share an edge or a corner). 
// 
//
// The length of a clear path is the number of visited cells of this path. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,1],[1,0]]
//Output: 2
// 
//
// Example 2: 
// 
// 
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
//
// Related Topics Array Breadth-First Search Matrix 👍 6698 👎 250


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
//            int n = grid.length;
//            if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
//
//            Queue<CellTuple> queue = new LinkedList<>();
//            queue.add(new CellTuple(1, 0, 0));
//
//            while (!queue.isEmpty()) {
//                CellTuple cellTuple = queue.poll();
//                int row = cellTuple.row;
//                int col = cellTuple.col;
//                int distance = cellTuple.distance;
//
//                if (row == n - 1 && col == n - 1) {
//                    return distance;
//                }
//
//                for (int i = -1; i <= 1; i++) {
//                    for (int j = -1; j <= 1; j++) {
//                        int newRow = row + i;
//                        int newCol = col + j;
//
//                        if (newCol >= 0 && newRow >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 0) {
//                            queue.add(new CellTuple(distance + 1, newRow, newCol));
//                            grid[newRow][newCol] = 1;
//                        }
//                    }
//                }
//            }
//
//            return -1;
            int n = grid.length;
            if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

            boolean[][] visited = new boolean[n][n];
            Queue<CellTuple> queue = new ArrayDeque<>();
            queue.add(new CellTuple(1, 0, 0));

            while (!queue.isEmpty()) {
                CellTuple cellTuple = queue.poll();
                int row = cellTuple.row;
                int col = cellTuple.col;
                int distance = cellTuple.distance;

                if (row == n - 1 && col == n - 1) {
                    return distance;
                }

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int newRow = row + i;
                        int newCol = col + j;

                        if (newCol >= 0 && newRow >= 0 && newRow < n && newCol < n && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                            queue.add(new CellTuple(distance + 1, newRow, newCol));
                            visited[newRow][newCol] = true;
                        }
                    }
                }
            }

            return -1;
        }

        class CellTuple {
            int distance;
            int row;
            int col;

            CellTuple(int distance, int row, int col) {
                this.distance = distance;
                this.row = row;
                this.col = col;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}