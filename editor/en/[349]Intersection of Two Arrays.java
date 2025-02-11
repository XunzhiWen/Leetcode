//Given two integer arrays nums1 and nums2, return an array of their
//intersection. Each element in the result must be unique and you may return the result in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics Array Hash Table Two Pointers Binary Search Sorting 👍 6332 👎
// 2316


package com.shuzijun.leetcode.editor.en;


import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int num : nums1) {
                hashSet.add(num);
            }
            ArrayList<Integer> res = new ArrayList<>();
            for (int num : nums2) {
                if (hashSet.contains(num)) {
                    res.add(num);
                    hashSet.remove(num);
                }
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}