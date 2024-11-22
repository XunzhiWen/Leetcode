//You are given an inclusive range [lower, upper] and a sorted unique integer
//array nums, where all elements are within the inclusive range. 
//
// A number x is considered missing if x is in the range [lower, upper] and x 
//is not in nums. 
//
// Return the shortest sorted list of ranges that exactly covers all the 
//missing numbers. That is, no element of nums is included in any of the ranges, and 
//each missing number is covered by one of the ranges. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [0,1,3,50,75], lower = 0, upper = 99
//Output: [[2,2],[4,49],[51,74],[76,99]]
//Explanation: The ranges are:
//[2,2]
//[4,49]
//[51,74]
//[76,99]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1], lower = -1, upper = -1
//Output: []
//Explanation: There are no missing ranges since there are no missing numbers.
// 
//
// 
// Constraints: 
//
// 
// -10⁹ <= lower <= upper <= 10⁹ 
// 0 <= nums.length <= 100 
// lower <= nums[i] <= upper 
// All the values of nums are unique. 
// 
//
// Related Topics Array 👍 1126 👎 2992


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        Solution solution = new MissingRanges().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length == 0) {
                result.add(Arrays.asList(lower, upper));
                return result;
            }
            if (nums[0] - lower >= 1) result.add(Arrays.asList(lower, nums[0] - 1));
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] > 1) result.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }
            if (upper - nums[nums.length - 1] >= 1) result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}