//Given an integer array nums with possible duplicates, randomly output the
//index of a given target number. You can assume that the given target number must 
//exist in the array. 
//
// Implement the Solution class: 
//
// 
// Solution(int[] nums) Initializes the object with the array nums. 
// int pick(int target) Picks a random index i from nums where nums[i] == 
//target. If there are multiple valid i's, then each index should have an equal 
//probability of returning. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Solution", "pick", "pick", "pick"]
//[[[1, 2, 3, 3, 3]], [3], [1], [3]]
//Output
//[null, 4, 0, 2]
//
//Explanation
//Solution solution = new Solution([1, 2, 3, 3, 3]);
//solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each 
//index should have equal probability of returning.
//solution.pick(1); // It should return 0. Since in the array only nums[0] is 
//equal to 1.
//solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each 
//index should have equal probability of returning.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// target is an integer from nums. 
// At most 10⁴ calls will be made to pick. 
// 
//
// Related Topics Hash Table Math Reservoir Sampling Randomized 👍 1320 👎 1292


package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomPickIndex {
    public static void main(String[] args) {
        Solution solution = new RandomPickIndex().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, List<Integer>> hashMap;

        public Solution(int[] nums) {
            hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hashMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
                hashMap.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list = hashMap.get(target);
            return list.get((int) (Math.random() * list.size()));
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}