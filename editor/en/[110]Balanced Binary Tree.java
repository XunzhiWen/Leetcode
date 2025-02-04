/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = []
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 5000].
 * -10⁴ <= Node.val <= 10⁴
 * <p>
 * <p>
 * Related Topics Tree Depth-First Search Binary Tree 👍 11152 👎 746
 */

package com.shuzijun.leetcode.editor.en;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }

        private int height(TreeNode node) {
            if (node == null) return 0;
            int left = height(node.left);
            int right = height(node.right);
            if (left == -1 || right == -1) return -1;
            if (Math.abs(left - right) <= 1) {
                return 1 + Math.max(left, right);
            } else return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}