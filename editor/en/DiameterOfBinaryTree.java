//Given the root of a binary tree, return the length of the diameter of the
//tree. 
//
// The diameter of a binary tree is the length of the longest path between any 
//two nodes in a tree. This path may or may not pass through the root. 
//
// The length of a path between two nodes is represented by the number of edges 
//between them. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3,4,5]
//Output: 3
//Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Example 2: 
//
// 
//Input: root = [1,2]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 10⁴]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Binary Tree 👍 14188 👎 1086


package com.shuzijun.leetcode.editor.en;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
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
        int diameter;

        public int diameterOfBinaryTree(TreeNode root) {
            diameter = 0;
            LongestPath(root);
            return diameter;
        }

        private int LongestPath(TreeNode node) {
            if (node == null) return 0;
            int leftLen = LongestPath(node.left);
            int rightLen = LongestPath(node.right);

            diameter = Math.max(leftLen + rightLen, diameter);

            return Math.max(leftLen, rightLen) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}