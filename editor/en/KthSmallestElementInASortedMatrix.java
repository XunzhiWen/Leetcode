//Given an n x n matrix where each of the rows and columns is sorted in
//ascending order, return the kᵗʰ smallest element in the matrix. 
//
// Note that it is the kᵗʰ smallest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must find a solution with a memory complexity better than O(n²). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and 
//the 8ᵗʰ smallest number is 13
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-5]], k = 1
//Output: -5
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the rows and columns of matrix are guaranteed to be sorted in non-
//decreasing order. 
// 1 <= k <= n² 
// 
//
// 
// Follow up: 
//
// 
// Could you solve the problem with a constant memory (i.e., O(1) memory 
//complexity)? 
// Could you solve the problem in O(n) time complexity? The solution may be too 
//advanced for an interview but you may find reading this paper fun. 
// 
//
// Related Topics Array Binary Search Sorting Heap (Priority Queue) Matrix 👍 10
//053 👎 360


package com.shuzijun.leetcode.editor.en;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length; // 矩阵大小为 N x N
            int low = matrix[0][0];
            int high = matrix[n - 1][n - 1];

            // 二分搜索
            while (low < high) {
                int mid = low + (high - low) / 2;

                // 统计小于等于 mid 的元素个数
                int count = countLessEqual(matrix, mid);

                if (count >= k) {
                    high = mid; // 第 K 小的元素在左侧或是 mid 本身
                } else {
                    low = mid + 1; // 第 K 小的元素在右侧
                }
            }

            return low; // 第 K 小的元素
        }

        private int countLessEqual(int[][] matrix, int target) {
            int count = 0, n = matrix.length, row = n - 1, col = 0;
            while (row >= 0 && col < n) {
                if (matrix[row][col] <= target) {
                    count += row + 1;
                    col++;
                } else row--;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}