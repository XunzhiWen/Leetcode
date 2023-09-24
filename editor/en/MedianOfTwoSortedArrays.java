//Given two sorted arrays nums1 and nums2 of size m and n respectively, return
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics Array Binary Search Divide and Conquer 👍 26210 👎 2881


package com.shuzijun.leetcode.editor.en;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            if (m > n) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int left = 0, right = m;

            while (left <= right) {
                int partitionA = (left + right) / 2, partitionB = (m + n + 1) / 2 - partitionA;
                int leftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
                int rightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
                int leftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
                int rightB = partitionB == n ? Integer.MAX_VALUE : nums2[partitionB];
                if (leftA <= rightB && leftB <= rightA) {
                    if ((m + n) % 2 == 0) {
                        return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                    } else {
                        return Math.max(leftA, leftB);
                    }
                } else if (leftA > rightB) {
                    right = partitionA - 1;
                } else {
                    left = partitionA + 1;
                }
            }
            return 0.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}