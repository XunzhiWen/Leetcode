//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not 
//matter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Sorting 👍 28537 👎 2562


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n && nums[i] <= 0; i++) {
                if (i == 0 || nums[i - 1] != nums[i]) {
//                    towSumII(nums, i, res);
                    towSum(nums, i, res);
                }

            }
            return res;
        }

        private void towSum(int[] nums, int targetIdx, List<List<Integer>> res) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = targetIdx + 1; i < nums.length; i++) {
                int complement = -nums[targetIdx] - nums[i];
                if (hashSet.contains(complement)) {
                    res.add(Arrays.asList(nums[targetIdx], nums[i], complement));
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
                hashSet.add(nums[i]);
            }
        }

        private void towSumII(int[] nums, int targetIdx, List<List<Integer>> res) {
            int left = targetIdx + 1, right = nums.length - 1;
            int complement = -nums[targetIdx];
            while (left < right) {
                if (nums[left] + nums[right] < complement) {
                    left++;
                } else if (nums[left] + nums[right] > complement) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[left++], nums[right--], nums[targetIdx]));
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}