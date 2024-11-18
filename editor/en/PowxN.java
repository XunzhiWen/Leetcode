//Implement pow(x, n), which calculates x raised to the power n (i.e., xⁿ).
//
// 
// Example 1: 
//
// 
//Input: x = 2.00000, n = 10
//Output: 1024.00000
// 
//
// Example 2: 
//
// 
//Input: x = 2.10000, n = 3
//Output: 9.26100
// 
//
// Example 3: 
//
// 
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2⁻² = 1/2² = 1/4 = 0.25
// 
//
// 
// Constraints: 
//
// 
// -100.0 < x < 100.0 
// -2³¹ <= n <= 2³¹-1 
// n is an integer. 
// Either x is not zero or n > 0. 
// -10⁴ <= xⁿ <= 10⁴ 
// 
//
// Related Topics Math Recursion 👍 10113 👎 9797


package com.shuzijun.leetcode.editor.en;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            return Exp(x,(long) n);
        }
        private double Exp(double x, long n){
            if (n == 0) return 1;
            if (n < 0) return 1 / Exp(x, -1 * n);
            if (n % 2 == 0) return Exp(x * x, n / 2);
            else return x * Exp(x * x, (n - 1) / 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}