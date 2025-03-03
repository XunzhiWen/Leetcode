//Given n non-negative integers representing an elevation map where the width
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
// 
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 33503 👎 584


package com.shuzijun.leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
//            最优解，双指针法
/*            if (height.length <= 2) return 0;
            int left = 0, right = height.length - 1;
            int maxLeft = height[left], maxRight = height[right];
            int sum = 0;
            while (left < right) {
                if (maxLeft < maxRight) {
                    left++;
                    maxLeft = Math.max(maxLeft, height[left]);
                    sum += maxLeft - height[left];
                } else {
                    right--;
                    maxRight = Math.max(maxRight, height[right]);
                    sum += maxRight - height[right];
                }
            }
            return sum;*/

//            单调栈法，空间O(N)非最优
            if (height.length <= 2) return 0;
            Deque<Integer> stack = new LinkedList<>();
            int sum = 0;

            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int bottom = stack.pop();
                    if (stack.isEmpty()) break;
                    int left = stack.peek();
                    int h = Math.min(height[left], height[i]) - height[bottom];
                    int w = i - left - 1;
                    sum += h * w;
                }
                stack.push(i);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}