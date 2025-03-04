/**
 * <p>Given an array of <code>points</code> where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> represents a point on the <strong>X-Y</strong> plane and an integer <code>k</code>, return the <code>k</code> closest points to the origin <code>(0, 0)</code>.</p>
 *
 * <p>The distance between two points on the <strong>X-Y</strong> plane is the Euclidean distance (i.e., <code>√(x<sub>1</sub> - x<sub>2</sub>)<sup>2</sup> + (y<sub>1</sub> - y<sub>2</sub>)<sup>2</sup></code>).</p>
 *
 * <p>You may return the answer in <strong>any order</strong>. The answer is <strong>guaranteed</strong> to be <strong>unique</strong> (except for the order that it is in).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/closestplane1.jpg" style="width: 400px; height: 400px;" />
 * <pre>
 * <strong>Input:</strong> points = [[1,3],[-2,2]], k = 1
 * <strong>Output:</strong> [[-2,2]]
 * <strong>Explanation:</strong>
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) &lt; sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> points = [[3,3],[5,-1],[-2,4]], k = 2
 * <strong>Output:</strong> [[3,3],[-2,4]]
 * <strong>Explanation:</strong> The answer [[-2,4],[3,3]] would also be accepted.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= k &lt;= points.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Math</li><li>Divide and Conquer</li><li>Geometry</li><li>Sorting</li><li>Heap (Priority Queue)</li><li>Quickselect</li></div></div><br><div><li>👍 8548</li><li>👎 312</li></div>
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution solution = new KClosestPointsToOrigin().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            int left = 0, right = points.length - 1;
            while (left < right) {
                int pivotIndex = partition(points, left, right);
                if (pivotIndex == k - 1) break;
                else if (pivotIndex < k - 1) left = pivotIndex + 1;
                else right = pivotIndex - 1;
            }
            return Arrays.copyOf(points, k);
        }

        private int partition(int[][] points, int left, int right) {
            int pivot = EuclidDistance(points, right);
            int i = left;
            for (int j = left; j < right; j++) {
                if (EuclidDistance(points, j) <= pivot) {
                    swap(points, i, j);
                    i++;
                }
            }
            swap(points, i, right);
            return i;
        }

        private void swap(int[][] points, int i, int j) {
            int[] temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }

        private int EuclidDistance(int[][] points, int i) {
            return points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}