/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 10⁷
 * root is a binary search tree.
 * 1 <= val <= 10⁷
 * <p>
 * <p>
 * Related Topics Tree Binary Search Tree Binary Tree 👍 6137 👎 197
 */

package com.shuzijun.leetcode.editor.en;

public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();
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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) return root;
            else if (root.val < val) return searchBST(root.right, val);
            else return searchBST(root.left, val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}