/**
 * Given the root of a complete binary tree, return the number of the nodes in the
 * tree.
 * <p>
 * According to Wikipedia, every level, except possibly the last, is completely
 * filled in a complete binary tree, and all nodes in the last level are as far left
 * as possible. It can have between 1 and 2ʰ nodes inclusive at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = []
 * Output: 0
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: root = [1]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [0, 5 * 10⁴].
 * 0 <= Node.val <= 5 * 10⁴
 * The tree is guaranteed to be complete.
 * <p>
 * <p>
 * Related Topics Binary Search Bit Manipulation Tree Binary Tree 👍 8928 👎 553
 */

package com.shuzijun.leetcode.editor.en;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
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
        public int countNodes(TreeNode root) {
/*
//            DFS，时间非最优
            if (root == null) return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
*/

//            DFS, 利用完全二叉树性质
            if (root == null) return 0;
            TreeNode left = root.left;
            TreeNode right = root.right;

            int leftDepth = 0, rightDepth = 0;
            while (left != null) {
                leftDepth++;
                left = left.left;
            }
            while (right != null) {
                rightDepth++;
                right = right.right;
            }

            if (leftDepth == rightDepth) return (int) Math.pow(2, leftDepth + 1) - 1;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}