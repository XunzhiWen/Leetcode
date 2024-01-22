  //Given a non-negative integer x, return the square root of x rounded down to 
//the nearest integer. The returned integer should be non-negative as well. 
//
// You must not use any built-in exponent function or operator. 
//
// 
// For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
// 
//
// 
// Example 1: 
//
// 
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
// 
//
// Example 2: 
//
// 
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down 
//to the nearest integer, 2 is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics Math Binary Search 👍 7789 👎 4427

  
  package com.shuzijun.leetcode.editor.en;
  public class Sqrtx{
      public static void main(String[] args) {
           Solution solution = new Sqrtx().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if  (x<2){
            return x;
        }
        int left =2, right = x/2;
        while (left<=right){
            int mid = left+(right-left)/2;
            long num = (long)mid*mid;
            if (num==x){
                return mid;
            }
            else if (num<x){
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }