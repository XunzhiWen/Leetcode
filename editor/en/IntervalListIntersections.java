//You are given two lists of closed intervals, firstList and secondList, where
//firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of 
//intervals is pairwise disjoint and in sorted order. 
//
// Return the intersection of these two interval lists. 
//
// A closed interval [a, b] (with a <= b) denotes the set of real numbers x 
//with a <= x <= b. 
//
// The intersection of two closed intervals is a set of real numbers that are 
//either empty or represented as a closed interval. For example, the intersection 
//of [1, 3] and [2, 4] is [2, 3]. 
//
// 
// Example 1: 
// 
// 
//Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],
//[15,24],[25,26]]
//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// Example 2: 
//
// 
//Input: firstList = [[1,3],[5,9]], secondList = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 10⁹ 
// endi < starti+1 
// 0 <= startj < endj <= 10⁹ 
// endj < startj+1 
// 
//
// Related Topics Array Two Pointers 👍 5634 👎 117


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;

public class IntervalListIntersections {
    public static void main(String[] args) {
        Solution solution = new IntervalListIntersections().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int ptr1 = 0, ptr2 = 0;
            ArrayList<int[]> list = new ArrayList<>();
            while (ptr1 < firstList.length && ptr2 < secondList.length) {
                int[] interval1 = firstList[ptr1];
                int[] interval2 = secondList[ptr2];
                int start = Math.max(interval1[0], interval2[0]);
                int end = Math.min(interval2[1], interval1[1]);
                if (start <= end) list.add(new int[]{start, end});
                if (interval1[1] <= interval2[1]) ptr1++;
                else ptr2++;

            }

            return list.toArray(new int[list.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}