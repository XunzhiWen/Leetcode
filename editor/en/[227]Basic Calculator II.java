/**
 * Given a string s which represents an expression, evaluate this expression and
 * return its value.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-2³¹, 2³¹ - 1].
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings
 * as mathematical expressions, such as eval().
 * <p>
 * <p>
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * <p>
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * <p>
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 3 * 10⁵
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 2
 * ³¹ - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * <p>
 * Related Topics Math String Stack 👍 6275 👎 886
 */

package com.shuzijun.leetcode.editor.en;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            int result = 0;       // 存储结果
            int lastNumber = 0;   // 记录上一个计算的数
            int currentNumber = 0; // 当前数字
            char operation = '+'; // 初始化操作符为 '+'

            // 遍历整个字符串
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                // 如果字符是数字
                if (Character.isDigit(ch)) {
                    currentNumber = currentNumber * 10 + (ch - '0');
                }

                // 如果是操作符或者已经到了字符串末尾
                if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                    if (operation == '+') {
                        result += lastNumber;      // 对上一轮结果进行加法
                        lastNumber = currentNumber; // 更新 lastNumber
                    } else if (operation == '-') {
                        result += lastNumber;      // 对上一轮结果进行减法
                        lastNumber = -currentNumber; // 更新 lastNumber 为负数
                    } else if (operation == '*') {
                        lastNumber *= currentNumber; // 进行乘法
                    } else if (operation == '/') {
                        lastNumber = lastNumber / currentNumber; // 进行除法
                    }

                    // 更新当前操作符
                    operation = ch;
                    currentNumber = 0; // 重置 currentNumber 以便计算下一个数字
                }
            }

            // 最后一次的 result 需要加上 lastNumber
            result += lastNumber;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}