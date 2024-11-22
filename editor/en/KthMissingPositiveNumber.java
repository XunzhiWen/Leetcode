//Given an array arr of positive integers sorted in a strictly increasing order,
// and an integer k. 
//
// Return the kᵗʰ positive integer that is missing from this array. 
//
// 
// Example 1: 
//
// 
//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5
//ᵗʰ missing positive integer is 9.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,2,3,4], k = 2
//Output: 6
//Explanation: The missing positive integers are [5,6,7,...]. The 2ⁿᵈ missing 
//positive integer is 6.
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// arr[i] < arr[j] for 1 <= i < j <= arr.length 
// 
//
// 
// Follow up: 
//
// Could you solve this problem in less than O(n) complexity? 
//
// Related Topics Array Binary Search 👍 6895 👎 483


package com.shuzijun.leetcode.editor.en;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        Solution solution = new KthMissingPositiveNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthPositive(int[] arr, int k) {
//            Brute Force
/*            for (int num : arr) {
                if (num <= k) {
                    k++;
                } else break;
            }
            return k;*/

            int left = 0, right = arr.length - 1;
//            Inclusive interval
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] - mid - 1 < k) left = mid + 1;
                else right = mid - 1;

            }
            return left + k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}