/**
 * You are given an absolute path for a Unix-style file system, which always
 * begins with a slash '/'. Your task is to transform this absolute path into its
 * simplified canonical path.
 * <p>
 * The rules of a Unix-style file system are as follows:
 * <p>
 * <p>
 * A single period '.' represents the current directory.
 * A double period '..' represents the previous/parent directory.
 * Multiple consecutive slashes such as '//' and '///' are treated as a single
 * slash '/'.
 * Any sequence of periods that does not match the rules above should be treated
 * as a valid directory or file name. For example, '...' and '....' are valid
 * directory or file names.
 * <p>
 * <p>
 * The simplified canonical path should follow these rules:
 * <p>
 * <p>
 * The path must start with a single slash '/'.
 * Directories within the path must be separated by exactly one slash '/'.
 * The path must not end with a slash '/', unless it is the root directory.
 * The path must not have any single or double periods ('.' and '..') used to
 * denote current or parent directories.
 * <p>
 * <p>
 * Return the simplified canonical path.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: path = "/home/"
 * <p>
 * <p>
 * Output: "/home"
 * <p>
 * Explanation:
 * <p>
 * The trailing slash should be removed.
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: path = "/home//foo/"
 * <p>
 * <p>
 * Output: "/home/foo"
 * <p>
 * Explanation:
 * <p>
 * Multiple consecutive slashes are replaced by a single one.
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: path = "/home/user/Documents/../Pictures"
 * <p>
 * <p>
 * Output: "/home/user/Pictures"
 * <p>
 * Explanation:
 * <p>
 * A double period ".." refers to the directory up a level (the parent directory).
 * <p>
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: path = "/../"
 * <p>
 * <p>
 * Output: "/"
 * <p>
 * Explanation:
 * <p>
 * Going one level up from the root directory is not possible.
 * <p>
 * Example 5:
 * <p>
 * <p>
 * Input: path = "/.../a/../b/c/../d/./"
 * <p>
 * <p>
 * Output: "/.../b/d"
 * <p>
 * Explanation:
 * <p>
 * "..." is a valid name for a directory in this problem.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 * <p>
 * <p>
 * Related Topics String Stack 👍 5822 👎 1324
 */

package com.shuzijun.leetcode.editor.en;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            // Initialize a stack
            Stack<String> stack = new Stack<String>();
            String[] components = path.split("/");

            // Split the input string on "/" as the delimiter
            // and process each portion one by one
            for (String directory : components) {
                // A no-op for a "." or an empty string
                if (directory.equals(".") || directory.isEmpty()) {
                    continue;
                } else if (directory.equals("..")) {
                    // If the current component is a "..", then
                    // we pop an entry from the stack if it's non-empty
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    // Finally, a legitimate directory name, so we add it
                    // to our stack
                    stack.add(directory);
                }
            }

            // Stich together all the directory names together
            StringBuilder result = new StringBuilder();
            for (String dir : stack) {
                result.append("/");
                result.append(dir);
            }

            return result.length() > 0 ? result.toString() : "/";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}