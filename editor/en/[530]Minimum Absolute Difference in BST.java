//Given the root of a Binary Search Tree (BST), return the minimum absolute
//difference between the values of any two different nodes in the tree. 
//
// 
// Example 1: 
// 
// 
//Input: root = [4,2,6,1,3]
//Output: 1
// 
//
// Example 2: 
// 
// 
//Input: root = [1,0,48,null,null,12,49]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁴]. 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
// Note: This question is the same as 783: https://leetcode.com/problems/
//minimum-distance-between-bst-nodes/ 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Search 
//Tree Binary Tree 👍 4516 👎 242


package com.shuzijun.leetcode.editor.en;

public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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
        public int getMinimumDifference(TreeNode root) {
            return inOrder(root, new int[]{Integer.MAX_VALUE}, new TreeNode[]{null});
        }

        private int inOrder(TreeNode root, int[] min, TreeNode[] pre) {
            if (root == null) return min[0];
            inOrder(root.left, min, pre);
            if (pre[0] != null) {
                min[0] = Math.min(Math.abs(pre[0].val - root.val), min[0]);
            }
            pre[0] = root;
            inOrder(root.right, min, pre);
            return min[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}