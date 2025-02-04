/**
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * A leaf is a node with no children.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1]
 * Output: ["1"]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics String Backtracking Tree Depth-First Search Binary Tree 👍 6787
 * 👎 316
 */

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<TreeNode> cur = new ArrayList<>();
            List<String> res = new ArrayList<>();
            backTracking(root, cur, res);
            return res;
        }

        private void backTracking(TreeNode node, List<TreeNode> cur, List<String> res) {
            cur.add(node);
            if (node.left == null && node.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < cur.size() - 1; i++) {
                    sb.append(cur.get(i).val);
                    sb.append("->");
                }
                sb.append(cur.get(cur.size() - 1).val);
                res.add(sb.toString());
                return;
            }

            if (node.left != null) {
                backTracking(node.left, cur, res);
                cur.removeLast();
            }

            if (node.right != null) {
                backTracking(node.right, cur, res);
                cur.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}