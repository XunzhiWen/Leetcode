/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * <p>
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [1, 10⁴].
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics Tree Depth-First Search Binary Tree 👍 14254 👎 1098
 */

package com.shuzijun.leetcode.editor.en;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
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
        int maxDiameter;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDiameter = 0;
            helper(root);
            return maxDiameter;
        }

        private int helper(TreeNode root) {
            if (root == null) return 0;
            int left = 0, right = 0;
            if (root.left != null) left = helper(root.left);
            if (root.right != null) right = helper(root.right);
            maxDiameter = Math.max(maxDiameter, left + right);
            return Math.max(left, right) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}