/**
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's
 * (representing civilians). The soldiers are positioned in front of the civilians.
 * That is, all the 1's will appear to the left of all the 0's in each row.
 * <p>
 * A row i is weaker than a row j if one of the following is true:
 * <p>
 * <p>
 * The number of soldiers in row i is less than the number of soldiers in row j.
 * Both rows have the same number of soldiers and i < j.
 * <p>
 * <p>
 * Return the indices of the k weakest rows in the matrix ordered from weakest to
 * strongest.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 2
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 2
 * - Row 4: 5
 * The rows ordered from weakest to strongest are [2,0,3,1,4].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers in each row is:
 * - Row 0: 1
 * - Row 1: 4
 * - Row 2: 1
 * - Row 3: 1
 * The rows ordered from weakest to strongest are [0,2,3,1].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 * <p>
 * <p>
 * Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix 👍 4205
 * 👎 235
 */

package com.shuzijun.leetcode.editor.en;

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    public static void main(String[] args) {
        Solution solution = new TheKWeakestRowsInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int m = mat.length;
            int n = mat[0].length;

            // 优先队列 (最小堆), 存储 (强度, 行索引)
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                // 比较强度，如果强度相等，按索引升序排列
                if (a[0] == b[0]) {
                    return a[1] - b[1]; // 按行索引升序排列
                } else {
                    return a[0] - b[0]; // 按强度升序排列
                }
            });

            // 遍历矩阵，计算每行的强度，并将其存入优先队列
            for (int i = 0; i < m; i++) {
                // 使用二分查找计算当前行的强度
                int strength = binarySearch(mat[i]);
                pq.offer(new int[]{strength, i});
            }

            // 从优先队列中提取前 k 个最弱行的索引
            int[] result = new int[k];
            int index = 0;
            while (index < k) {
                result[index++] = pq.poll()[1]; // 提取行索引
            }

            return result;

        }

        private void reverse(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        private int binarySearch(int[] row) {
            int low = 0, high = row.length;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (row[mid] == 1) {
                    low = mid + 1; // 继续在右半部分查找
                } else {
                    high = mid; // 继续在左半部分查找
                }
            }
            return low; // low 就是该行的强度
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}