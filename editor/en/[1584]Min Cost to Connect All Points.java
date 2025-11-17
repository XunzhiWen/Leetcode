/**
 * You are given an array points representing integer coordinates of some points
 * on a 2D-plane, where points[i] = [xi, yi].
 * <p>
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan
 * distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value
 * of val.
 * <p>
 * Return the minimum cost to make all points connected. All points are connected
 * if there is exactly one simple path between any two points.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 * <p>
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= points.length <= 1000
 * -10⁶ <= xi, yi <= 10⁶
 * All pairs (xi, yi) are distinct.
 * <p>
 * <p>
 * Related Topics Array Union Find Graph Minimum Spanning Tree 👍 5502 👎 142
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new MinCostToConnectAllPoints().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            int[] minDist = new int[n];
            Arrays.fill(minDist, 20000001);
            minDist[0] = 0;
            boolean[] isInTree = new boolean[n];
            int res = 0;
            for (int i = 0; i < n; i++) {
                int curr = -1, minVal = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (!isInTree[j] && minDist[j] < minVal) {
                        minVal = minDist[j];
                        curr = j;
                    }
                }
                isInTree[curr] = true;
                res += minVal;
                for (int j = 0; j < n; j++) {
                    int dist = pointDist(points[curr], points[j]);
                    if (!isInTree[j] && dist < minDist[j]) {
                        minDist[j] = dist;
                    }
                }
            }

            return res;
        }

        private int pointDist(int[] pointX, int[] pointY) {
            return Math.abs(pointX[0] - pointY[0]) + Math.abs(pointX[1] - pointY[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}