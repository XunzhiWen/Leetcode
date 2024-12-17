/**
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can only
 * see the k numbers in the window. Each time the sliding window moves right by one
 * position.
 * <p>
 * Return the max sliding window.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * 1 <= k <= nums.length
 * <p>
 * <p>
 * Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic
 * Queue 👍 18664 👎 711
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) return null;
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && (nums[deque.peekLast()] <= nums[i])) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            res[0] = nums[deque.peekFirst()];
            for (int i = k; i < nums.length; i++) {
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && (nums[deque.peekLast()] <= nums[i])) {
                    deque.pollLast();
                }


                deque.offerLast(i);
                res[i - k + 1] = nums[deque.peekFirst()];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}