//Given two non-negative integers num1 and num2 represented as strings, return
//the product of num1 and num2, also represented as a string. 
//
// Note: You must not use any built-in BigInteger library or convert the inputs 
//to integer directly. 
//
// 
// Example 1: 
// Input: num1 = "2", num2 = "3"
//Output: "6"
// 
// Example 2: 
// Input: num1 = "123", num2 = "456"
//Output: "56088"
// 
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 and num2 consist of digits only. 
// Both num1 and num2 do not contain any leading zero, except the number 0 
//itself. 
// 
//
// Related Topics Math String Simulation 👍 7213 👎 3433


package com.shuzijun.leetcode.editor.en;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int len1 = num1.length();
            int len2 = num2.length();
            int len = len1 + len2;
            int[] product = new int[len];
            for (int i = num1.length() - 1; i >= 0; i--) {
                int a = num1.charAt(i) - '0';
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int b = num2.charAt(j) - '0';
                    int idx = i + j + 1;
                    int p = a * b + product[idx];
                    product[idx] = p % 10;
                    product[idx - 1] += p / 10;
                }
            }

            int start = product[0] != 0 ? 0 : 1;
            StringBuilder result = new StringBuilder();
            for (int i = start; i < len; i++) {
                result.append(product[i]);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}