/**
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in the
 * histogram.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: heights = [2,4]
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= heights.length <= 10⁵
 * 0 <= heights[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics Array Stack Monotonic Stack 👍 17709 👎 304
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            Deque<Integer> stack = new LinkedList<>();
            int maxArea = 0;

            for (int i = 0; i <= n; i++) {
                int h = (i == n) ? 0 : heights[i];
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int width = i - left - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}