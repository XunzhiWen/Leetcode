//Given two integer arrays nums1 and nums2, return an array of their
//intersection. Each element in the result must appear as many times as it shows in both 
//arrays and you may return the result in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
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
// 
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your 
//algorithm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is 
//better? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
//
// Related Topics Array Hash Table Two Pointers Binary Search Sorting 👍 7844 👎
// 988


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            ArrayList<Integer> res = new ArrayList<>();
            for (int num : nums1) {
                hashMap.putIfAbsent(num, 0);
                hashMap.put(num, hashMap.get(num) + 1);
            }
            for (int num : nums2) {
                if (hashMap.containsKey(num) && hashMap.get(num) > 0) {
                    hashMap.put(num, hashMap.get(num) - 1);
                    res.add(num);
                }
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}