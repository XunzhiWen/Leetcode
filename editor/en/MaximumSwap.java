//You are given an integer num. You can swap two digits at most once to get the
//maximum valued number. 
//
// Return the maximum valued number you can get. 
//
// 
// Example 1: 
//
// 
//Input: num = 2736
//Output: 7236
//Explanation: Swap the number 2 and the number 7.
// 
//
// Example 2: 
//
// 
//Input: num = 9973
//Output: 9973
//Explanation: No swap.
// 
//
// 
// Constraints: 
//
// 
// 0 <= num <= 10⁸ 
// 
//
// Related Topics Math Greedy 👍 4065 👎 258


package com.shuzijun.leetcode.editor.en;

public class MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            String numStr = Integer.toString(num);
            int n = numStr.length();
            char[] arr = numStr.toCharArray();
            int maxRight = -1, swapIdx1 = -1, swapIdx2 = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (maxRight == -1 || arr[i] > arr[maxRight]) {
                    maxRight = i;
                } else if (arr[i] < arr[maxRight]) {
                    swapIdx1 = i;
                    swapIdx2 = maxRight;
                }
            }
            if (swapIdx1 != -1) {
                swap(arr, swapIdx1, swapIdx2);
                return Integer.parseInt(new String(arr));
            }
            return num;
        }

        private void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}