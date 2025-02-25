//Given the roots of two binary trees root and subRoot, return true if there is
//a subtree of root with the same structure and node values of subRoot and false 
//otherwise. 
//
// A subtree of a binary tree tree is a tree that consists of a node in tree 
//and all of this node's descendants. The tree tree could also be considered as a 
//subtree of itself. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the root tree is in the range [1, 2000]. 
// The number of nodes in the subRoot tree is in the range [1, 1000]. 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
//
// Related Topics Tree Depth-First Search String Matching Binary Tree Hash 
//Function 👍 8421 👎 543


package com.shuzijun.leetcode.editor.en;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) return false;
            if (compare(root, subRoot)) return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }

        private boolean compare(TreeNode root, TreeNode subRoot) {
            if (root == null || subRoot == null) return root == null && subRoot == null;

            return root.val == subRoot.val && compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}