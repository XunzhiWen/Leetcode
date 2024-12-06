//You are given an integer mountain array arr of length n where the values
//increase to a peak element and then decrease. 
//
// Return the index of the peak element. 
//
// Your task is to solve it in O(log(n)) time complexity. 
//
// 
// Example 1: 
//
// 
// Input: arr = [0,1,0] 
// 
//
// Output: 1 
//
// Example 2: 
//
// 
// Input: arr = [0,2,1,0] 
// 
//
// Output: 1 
//
// Example 3: 
//
// 
// Input: arr = [0,10,5,2] 
// 
//
// Output: 1 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 10⁵ 
// 0 <= arr[i] <= 10⁶ 
// arr is guaranteed to be a mountain array. 
// 
//
// Related Topics Array Binary Search 👍 7716 👎 1926


package com.shuzijun.leetcode.editor.en;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new PeakIndexInAMountainArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0, r = arr.length - 1, mid;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (arr[mid] < arr[mid + 1]) l = mid + 1;
                else r = mid - 1;
            }
            return l;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}