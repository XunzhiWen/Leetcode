/**
 * <p>Given a <code>file</code> and assume that you can only read the file using a given method <code>read4</code>, implement a method to read <code>n</code> characters.</p>
 *
 * <p><strong>Method read4: </strong></p>
 *
 * <p>The API <code>read4</code> reads <strong>four consecutive characters</strong> from <code>file</code>, then writes those characters into the buffer array <code>buf4</code>.</p>
 *
 * <p>The return value is the number of actual characters read.</p>
 *
 * <p>Note that <code>read4()</code> has its own file pointer, much like <code>FILE *fp</code> in C.</p>
 *
 * <p><strong>Definition of read4:</strong></p>
 *
 * <pre>
 * Parameter:  char[] buf4
 * Returns:    int
 *
 * buf4[] is a destination, not a source. The results from read4 will be copied to buf4[].
 * </pre>
 *
 * <p>Below is a high-level example of how <code>read4</code> works:</p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/07/01/157_example.png" style="width: 600px; height: 403px;" />
 * <pre>
 * File file("abcde<span><code>"); // File is "</code></span>abcde<span><code>", initially file pointer (fp) points to 'a'
 * char[] buf4 = new char[4]; // Create buffer with enough space to store characters
 * read4(buf4); // read4 returns 4. Now buf4 = "abcd", fp points to 'e'
 * read4(buf4); // read4 returns 1. Now buf4 = "e", fp points to end of file
 * read4(buf4); // read4 returns 0. Now buf4 = "", fp points to end of file</code></span>
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>Method read:</strong></p>
 *
 * <p>By using the <code>read4</code> method, implement the method read that reads <code>n</code> characters from <code>file</code> and store it in the buffer array <code>buf</code>. Consider that you cannot manipulate <code>file</code> directly.</p>
 *
 * <p>The return value is the number of actual characters read.</p>
 *
 * <p><strong>Definition of read: </strong></p>
 *
 * <pre>
 * Parameters:	char[] buf, int n
 * Returns:	int
 *
 * buf[] is a destination, not a source. You will need to write the results to buf[].
 * </pre>
 *
 * <p><strong>Note:</strong></p>
 *
 * <ul>
 * <li>Consider that you cannot manipulate the file directly. The file is only accessible for <code>read4</code> but not for <code>read</code>.</li>
 * <li>The <code>read</code> function will only be called once for each test case.</li>
 * <li>You may assume the destination buffer array, <code>buf</code>, is guaranteed to have enough space for storing <code>n</code> characters.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> file = "abc", n = 4
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> After calling your read method, buf should contain "abc". We read a total of 3 characters from the file, so return 3.
 * Note that "abc" is the file's content, not buf. buf is the destination buffer that you will have to write the results to.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> file = "abcde", n = 5
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> After calling your read method, buf should contain "abcde". We read a total of 5 characters from the file, so return 5.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> file = "abcdABCD1234", n = 12
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> After calling your read method, buf should contain "abcdABCD1234". We read a total of 12 characters from the file, so return 12.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= file.length &lt;= 500</code></li>
 * <li><code>file</code> consist of English letters and digits.</li>
 * <li><code>1 &lt;= n &lt;= 1000</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Simulation</li><li>Interactive</li></div></div><br><div><li>👍 580</li><li>👎 3509</li></div>
 */

package com.shuzijun.leetcode.editor.en;

public class ReadNCharactersGivenRead4 {
    public static void main(String[] args) {
        Solution solution = new ReadNCharactersGivenRead4().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf4);
     */

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int copiedChars = 0, readChars = 4;
            char[] buf4 = new char[4];
            while (copiedChars < n && readChars == 4) {
                readChars = read4(buf4);
                for (int i = 0; i < readChars; i++) {
                    if (copiedChars == n) return copiedChars;
                    buf[copiedChars] = buf4[i];
                    ++copiedChars;
                }
            }
            return copiedChars;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

