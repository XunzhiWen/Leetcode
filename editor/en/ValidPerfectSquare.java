//Given a positive integer num, return true if num is a perfect square or false
//otherwise. 
//
// A perfect square is an integer that is the square of an integer. In other 
//words, it is the product of some integer with itself. 
//
// You must not use any built-in library function, such as sqrt. 
//
// 
// Example 1: 
//
// 
//Input: num = 16
//Output: true
//Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
// 
//
// Example 2: 
//
// 
//Input: num = 14
//Output: false
//Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an 
//integer.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 2³¹ - 1 
// 
//
// Related Topics Math Binary Search 👍 4094 👎 297


package com.shuzijun.leetcode.editor.en;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) return true;
            int left = 2, right = num / 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long sqr = (long) mid * mid;
                if (sqr == num) return true;
                else if (sqr < num) {
                    left = mid + 1;
                } else right = mid - 1;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}