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

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights.length == 0) return 0;
            int n = heights.length, maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int i = 0; i < n; i++) {
                while (stack.peek() != -1 && (heights[stack.peek()] >= heights[i])) {
                    int currHeight = heights[stack.pop()];
                    int currWidth = i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, currWidth * currHeight);
                }
                stack.push(i);
            }
            while (stack.peek() != -1) {
                int currHeight = heights[stack.pop()];
                int currWidth = n - stack.peek() - 1;
                maxArea = Math.max(maxArea, currWidth * currHeight);
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}