  /**
<p>You are given a <strong>large integer</strong> represented as an integer array <code>digits</code>, where each <code>digits[i]</code> is the <code>i<sup>th</sup></code> digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading <code>0</code>'s.</p>

<p>Increment the large integer by one and return <em>the resulting array of digits</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> digits = [1,2,3]
<strong>Output:</strong> [1,2,4]
<strong>Explanation:</strong> The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> digits = [4,3,2,1]
<strong>Output:</strong> [4,3,2,2]
<strong>Explanation:</strong> The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> digits = [9]
<strong>Output:</strong> [1,0]
<strong>Explanation:</strong> The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= digits.length &lt;= 100</code></li> 
 <li><code>0 &lt;= digits[i] &lt;= 9</code></li> 
 <li><code>digits</code> does not contain any leading <code>0</code>'s.</li> 
</ul>

<div><div>Related Topics</div><div><li>Array</li><li>Math</li></div></div><br><div><li>👍 6663</li><li>👎 4764</li></div>
*/
  
  package com.shuzijun.leetcode.editor.en;

  import java.util.Arrays;

  public class PlusOne{
      public static void main(String[] args) {
           Solution solution = new PlusOne().new Solution();
           int[] digits = {9,9};
           int[] result = solution.plusOne(digits);
           System.out.println(Arrays.toString(result));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        /* From the last digit, you can just return if it is not 9 because there will be no
        further changes. If there are 9s, then continue to add 1 on next digit and set this digit to 0.
         If every digit is 9, then create a new array with 1 at first and copy all the rest of digits
         to its back.*/
        int n = digits.length;
        for (int i = n-1;i>=0;i--){
            if (digits[i]!=9){
                digits[i]+=1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n+1];
        result[0]=1;
        for (int i=1;i< result.length;i++){
            result[i]=digits[i-1];
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }