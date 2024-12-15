/**
 * You are given two strings start and target, both of length n. Each string
 * consists only of the characters 'L', 'R', and '_' where:
 * <p>
 * <p>
 * The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the
 * left only if there is a blank space directly to its left, and a piece 'R' can
 * move to the right only if there is a blank space directly to its right.
 * The character '_' represents a blank space that can be occupied by any of the
 * 'L' or 'R' pieces.
 * <p>
 * <p>
 * Return true if it is possible to obtain the string target by moving the pieces
 * of the string start any number of times. Otherwise, return false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: start = "_L__R__R_", target = "L______RR"
 * Output: true
 * Explanation: We can obtain the string target from start by doing the following
 * moves:
 * - Move the first piece one step to the left, start becomes equal to "L___R__R_".
 * <p>
 * - Move the last piece one step to the right, start becomes equal to "L___R___R".
 * <p>
 * - Move the second piece three steps to the right, start becomes equal to "L_____
 * _RR".
 * Since it is possible to get the string target from start, we return true.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: start = "R_L_", target = "__LR"
 * Output: false
 * Explanation: The 'R' piece in the string start can move one step to the right
 * to obtain "_RL_".
 * After that, no pieces can move anymore, so it is impossible to obtain the
 * string target from start.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: start = "_R", target = "R_"
 * Output: false
 * Explanation: The piece in the string start can move only to the right, so it is
 * impossible to obtain the string target from start.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == start.length == target.length
 * 1 <= n <= 10⁵
 * start and target consist of the characters 'L', 'R', and '_'.
 * <p>
 * <p>
 * Related Topics Two Pointers String 👍 1332 👎 78
 */

package com.shuzijun.leetcode.editor.en;

public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        Solution solution = new MovePiecesToObtainAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canChange(String start, String target) {
            int i = 0, j = 0;
            while (i < start.length() || j < target.length()) {
                while (i < start.length() && start.charAt(i) == '_') i++;
                while (j < target.length() && target.charAt(j) == '_') j++;
                if (i == start.length() || j == target.length()) return i == start.length() && j == target.length();
                if ((start.charAt(i)!=target.charAt(j))||(start.charAt(i)=='L'&&i<j)||(start.charAt(i)=='R'&&i>j)) return false;
                i++;j++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}