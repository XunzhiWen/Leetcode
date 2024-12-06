//We are given an array asteroids of integers representing asteroids in a row.
//
// For each asteroid, the absolute value represents its size, and the sign 
//represents its direction (positive meaning right, negative meaning left). Each 
//asteroid moves at the same speed. 
//
// Find out the state of the asteroids after all collisions. If two asteroids 
//meet, the smaller one will explode. If both are the same size, both will explode. 
//Two asteroids moving in the same direction will never meet. 
//
// 
// Example 1: 
//
// 
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never 
//collide.
// 
//
// Example 2: 
//
// 
//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.
// 
//
// Example 3: 
//
// 
//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide 
//resulting in 10.
// 
//
// 
// Constraints: 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
//
// Related Topics Array Stack Simulation 👍 8291 👎 1154


package com.shuzijun.leetcode.editor.en;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            if (asteroids.length == 0) return asteroids;

            Stack<Integer> result = new Stack<>();

            for (int asteroid : asteroids) {
                // 处理当前小行星
                boolean destroyed = false;
                while (!result.isEmpty() && asteroid < 0 && result.peek() > 0) {
                    // 检查当前小行星与栈顶小行星的碰撞
                    if (Math.abs(result.peek()) < Math.abs(asteroid)) {
                        result.pop(); // 栈顶小行星被销毁
                    } else if (Math.abs(result.peek()) == Math.abs(asteroid)) {
                        result.pop(); // 两个小行星都被销毁
                        destroyed = true;
                        break;
                    } else {
                        destroyed = true; // 当前小行星被销毁
                        break;
                    }
                }

                if (!destroyed) {
                    result.push(asteroid); // 当前小行星没有被销毁，加入栈
                }
            }

            // 将 Stack 转换为 int[]
            int[] output = new int[result.size()];
            for (int i = output.length - 1; i >= 0; i--) {
                output[i] = result.pop();
            }
            return output;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}